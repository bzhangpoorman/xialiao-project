package com.bzhang.xialiao.service.impl;

import com.bzhang.xialiao.bean.FileConfig;
import com.bzhang.xialiao.bean.QrcodeConfig;
import com.bzhang.xialiao.mapper.ScUsersMapper;
import com.bzhang.xialiao.pojo.ScUsers;
import com.bzhang.xialiao.pojo.ScUsersExample;
import com.bzhang.xialiao.service.ScUsersService;
import com.bzhang.xialiao.utils.FtpUtil;
import com.bzhang.xialiao.utils.MD5Util;
import com.bzhang.xialiao.utils.QrcodeUtils;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by bzhang on 2019/5/9.
 */
@Service
public class ScUsersServiceImpl implements ScUsersService {
      @Autowired
      private ScUsersMapper scUsersMapper;

      @Autowired
      private Sid sid;

      @Autowired
      private QrcodeConfig qrcodeConfig;

      @Autowired
      private FileConfig fileConfig;

      @Transactional
      @Override
      public boolean queryUsernameIsExist(ScUsers user) {
            ScUsersExample example  = new ScUsersExample();
            example.createCriteria().andUsernameEqualTo(user.getUsername());
            List<ScUsers> list = scUsersMapper.selectByExample(example);
            if (list!=null&&list.size()>0){
                  return true;
            }
            return false;
      }

      @Transactional
      @Override
      public ScUsers selectUserByUsernameAndPwd(ScUsers user) {
            ScUsersExample example  = new ScUsersExample();
            example.createCriteria().andUsernameEqualTo(user.getUsername())
                  .andPasswordEqualTo(MD5Util.MD5EncodeUtf8(user.getPassword()));
            List<ScUsers> list = scUsersMapper.selectByExample(example);
            if (list!=null&&list.size()>0){
                  return list.get(0);
            }
            return null;
      }

      @Transactional
      @Override
      public int addUser(ScUsers user) {
            if (user.getPassword().length()>20||user.getPassword().length()<8){
                  return 0;
            }

            //组装用户信息
            Date date = new Date();
            user.setId(sid.nextShort());
            user.setNickname(user.getUsername());
            user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
            user.setCreated(date);
            user.setUpdated(date);
            user.setFaceImage("");
            user.setFaceImageBig("");
            user.setPhone("");


            //生成二维码图片，并将路径保存到用户信息中
            createQrcode(user);

            int res = scUsersMapper.insert(user);
            return res;
      }

      /**
       * 二维码图片生成,并保存二维码信息到用户中
       * @param user
       */
      private void createQrcode(ScUsers user) {
            String qrcodeImgName = user.getUsername()+"."+qrcodeConfig.getFormat();
            String content = qrcodeConfig.getPrefixContent()+user.getUsername();
            ByteArrayOutputStream qrcodeOutput = new ByteArrayOutputStream();
            QrcodeUtils.createQrcode(qrcodeOutput,content,qrcodeConfig.getFormat());

            //生成二维码图片的输入流，用于上传到图片服务器中
            ByteArrayInputStream qrcodeInput = new ByteArrayInputStream(qrcodeOutput.toByteArray());

            //ftp上传二维码图片到图片服务器
            boolean uploadRes = FtpUtil.uploadFile(fileConfig.getHost(), fileConfig.getPort(),
                    fileConfig.getUsername(), fileConfig.getPassword(), fileConfig.getBasepath(),
                    fileConfig.getFilepath(), qrcodeImgName,qrcodeInput );

            if (uploadRes){
                  user.setQrcode(qrcodeImgName);
            }else {
                  user.setQrcode("");
            }
      }

      @Transactional
      @Override
      public int updateUserById(ScUsers user) {
            ScUsersExample example = new ScUsersExample();
            example.createCriteria().andIdEqualTo(user.getId());
            //user.setId(null);
            user.setUpdated(new Date());
            int succ = scUsersMapper.updateByExampleSelective(user, example);
            return succ;
      }

      @Transactional
      @Override
      public ScUsers selectUserById(String id) {
            ScUsersExample example = new ScUsersExample();
            example.createCriteria().andIdEqualTo(id);
            List<ScUsers> list = scUsersMapper.selectByExample(example);
            if (list!=null&&list.size()>0){
                  return list.get(0);
            }
            return null;
      }

      @Transactional
      @Override
      public ScUsers updateUserQrcode(ScUsers user) {
            ScUsersExample example = new ScUsersExample();
            example.createCriteria().andIdEqualTo(user.getId());

            //生成二维码需要username信息，若是没有user中没有username信息，
            // 则根据id区数据库中查询后在生成二维码。
            if (StringUtils.isNotBlank(user.getUsername())){
                  createQrcode(user);
                  scUsersMapper.updateByExampleSelective(user,example);
                  return user;
            }else {
                  List<ScUsers> list = scUsersMapper.selectByExample(example);

                  //判断用户信息是否存在，若不存在直接返回user
                  if (list.size()>0){
                        user = list.get(0);
                        createQrcode(user);
                        scUsersMapper.updateByExampleSelective(user,example);
                  }
                  return user;
            }
      }


}
