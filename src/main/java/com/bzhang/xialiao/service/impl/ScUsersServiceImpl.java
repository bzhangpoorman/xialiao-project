package com.bzhang.xialiao.service.impl;

import com.bzhang.xialiao.mapper.ScUsersMapper;
import com.bzhang.xialiao.pojo.ScUsers;
import com.bzhang.xialiao.pojo.ScUsersExample;
import com.bzhang.xialiao.service.ScUsersService;
import com.bzhang.xialiao.utils.MD5Util;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

            Date date = new Date();
            user.setId(sid.nextShort());
            user.setNickname(user.getUsername());
            user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
            user.setCreated(date);
            user.setUpdated(date);
            user.setFaceImage("");
            user.setFaceImageBig("");
            user.setPhone("");
            user.setQrcode("");
            int res = scUsersMapper.insert(user);
            return res;
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


}
