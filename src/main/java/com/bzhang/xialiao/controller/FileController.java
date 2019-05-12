package com.bzhang.xialiao.controller;

import com.bzhang.xialiao.bean.FileConfig;
import com.bzhang.xialiao.pojo.ScUsers;
import com.bzhang.xialiao.pojo.bo.ScUserBO;
import com.bzhang.xialiao.service.ScUsersService;
import com.bzhang.xialiao.utils.FtpUtil;
import com.bzhang.xialiao.utils.ImageUtil;
import com.bzhang.xialiao.utils.ReturnMsg;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 图片上传
 * Created by bzhang on 2019/5/12.
 */
@RestController
@RequestMapping("/file")
public class FileController {

      @Autowired
      private Sid sid;

      @Autowired
      private FileConfig fileConfig;

      @Autowired
      private ScUsersService scUsersService;

      @PostMapping(value = "/upload")
      public ReturnMsg upload(@RequestBody ScUserBO scUserBO){
            ScUsers user = new ScUsers();
            user.setId(scUserBO.getUserId());
            System.out.println(scUserBO.getUserId());
            String faceImgStr = scUserBO.getFaceImgStr();
            String[] basesplit = faceImgStr.split("base64,");
            String base64 = null;
            if (basesplit.length==2){
                  base64 = basesplit[1];

            }else {
                  return ReturnMsg.err("文件上传出错！");
            }

            byte[] decodeFromString = Base64Utils.decodeFromString(base64);
            String newName = sid.nextShort()+".png";
            MultipartFile imagefile = new MockMultipartFile(newName,"png", "image/png",decodeFromString);

            //由大图生成小图
            MultipartFile imagefileSmall = ImageUtil.generateFixedSizeImage(imagefile, fileConfig.getSize());
            System.out.println(imagefileSmall);
            System.out.println(imagefileSmall.getName());
            if (imagefileSmall!=null){
                  try {
                        //ftp上传图片到图片服务器
                        boolean res1 = FtpUtil.uploadFile(fileConfig.getHost(), fileConfig.getPort(),
                                fileConfig.getUsername(), fileConfig.getPassword(), fileConfig.getBasepath(),
                                fileConfig.getFilepath(), newName, imagefile.getInputStream());
                        boolean res2 = FtpUtil.uploadFile(fileConfig.getHost(), fileConfig.getPort(),
                                fileConfig.getUsername(), fileConfig.getPassword(), fileConfig.getBasepath(),
                                fileConfig.getFilepath(), imagefileSmall.getName(), imagefileSmall.getInputStream());

                        if (res1 && res2){
                              //更新用户头像信息
                              user.setFaceImageBig(newName);
                              user.setFaceImage(imagefileSmall.getName());
                              int isSucc = scUsersService.updateUserById(user);

                              if (isSucc>0){
                                    return ReturnMsg.ok(newName);
                              }
                        }
                  } catch (IOException e) {
                        e.printStackTrace();
                  }
            }



            return ReturnMsg.err("文件上传出错！");



            //mutipartfile上传文件方式
            /*String filename = faceImg.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));
            String newName = sid.nextShort()+ suffix;
            try {
                  //ftp上传图片到图片服务器
                  boolean res = FtpUtil.uploadFile(fileConfig.getHost(), fileConfig.getPort(),
                          fileConfig.getUsername(), fileConfig.getPassword(), fileConfig.getBasepath(),
                          fileConfig.getFilepath(), newName, faceImg.getInputStream());
                  if (res){
                        //更新用户头像信息
                        user.setFaceImageBig(newName);
                        int isSucc = scUsersService.updateUserById(user);

                        if (isSucc>0){
                              return ReturnMsg.ok(newName);
                        }
                  }
            } catch (IOException e) {
                  e.printStackTrace();
            }

            return ReturnMsg.err("文件上传出错！");*/
      }
}
