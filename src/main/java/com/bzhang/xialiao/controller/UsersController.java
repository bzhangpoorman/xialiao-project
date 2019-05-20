package com.bzhang.xialiao.controller;

import com.bzhang.xialiao.pojo.ScUsers;
import com.bzhang.xialiao.pojo.vo.ScUsersVO;
import com.bzhang.xialiao.service.ScMyFriendsService;
import com.bzhang.xialiao.service.ScUsersService;
import com.bzhang.xialiao.utils.ReturnMsg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器，处理与用户相关请求
 * Created by bzhang on 2019/5/8.
 */
@RestController
@RequestMapping("/user")
public class UsersController {

      @Autowired
      private ScUsersService scUsersService;

      @Autowired
      private ScMyFriendsService scMyFriendsService;

      @PostMapping(value = "/registerOrLogin")
      public ReturnMsg registerOrLogin(ScUsers user){
            //判断密码或用户名是否为空
            System.out.println(user.getUsername()+user.getPassword());
            if (StringUtils.isBlank(user.getUsername())||StringUtils.isBlank(user.getPassword())){
                  return ReturnMsg.err("用户名或密码不能为空！");
            }

            //判断用户名是否已被使用
            boolean result = scUsersService.queryUsernameIsExist(user);

            //根据用户是否已经存在，来判断是登录还是注册操作
            if (result){
                  ScUsers loginUser = scUsersService.selectUserByUsernameAndPwd(user);
                  if (loginUser==null){
                        return ReturnMsg.err("用户名或密码不正确！");
                  }
                  return ReturnMsg.ok(ScUsersVO.getScUsersVO(loginUser));

            }else {
                  int isSuccess = scUsersService.addUser(user);
                  if (isSuccess == 0){
                        return ReturnMsg.err("注册失败!密码不符合要求");
                  }else if (isSuccess >= 1){
                        return ReturnMsg.ok(ScUsersVO.getScUsersVO(user));
                  }else {
                        return ReturnMsg.err("注册失败!");
                  }
            }
      }

      @PostMapping("/update/nickname")
      public ReturnMsg updateNickename(ScUsers user){
            if (user == null || StringUtils.isBlank(user.getId()) || StringUtils.isBlank(user.getNickname())){
                  return  ReturnMsg.err("数据不正确!");
            }
            int updateResult = scUsersService.updateUserById(user);
            if (updateResult == 1){
                  return ReturnMsg.ok(ReturnMsg.OK);
            }
            return ReturnMsg.err("更新昵称失败！");

      }

      @PostMapping("/get/qrcode")
      public ReturnMsg getQrcode(String id){
            if (id == null || StringUtils.isBlank(id)){
                  return  ReturnMsg.err("数据不正确!");
            }
            ScUsers user = scUsersService.selectUserById(id);
            if (user!=null){
                  //若用户存在二维码信息直接返回该信息
                  if (StringUtils.isNotBlank(user.getQrcode())){
                        return ReturnMsg.ok(user.getQrcode());
                  }else{
                        //若用户二维码信息不存在（生成二维码图片保存到图片服务器失败）
                        user = scUsersService.updateUserQrcode(user);
                        if (StringUtils.isNotBlank(user.getQrcode())){
                              return ReturnMsg.ok(user.getQrcode());
                        }

                  }
            }
            return ReturnMsg.err("二维码查询失败！");
      }

      @PostMapping("/search/username")
      public ReturnMsg searchUser(String id,String username){
            if (StringUtils.isBlank(username)){
                  return ReturnMsg.err("用户名不能为空！");

            }
            ScUsers user = scUsersService.selectUserByUsername(username);
            if (user!=null){
                  if (id == user.getId()){
                        return ReturnMsg.err("查询的是用户自己！");
                  }
                  int isFriendOrNot = scMyFriendsService.checkUserIsFriendOrNot(id, user.getId());
                  ScUsersVO userVO = ScUsersVO.getScUsersVO(user);
                  //未添加的好友
                  if (isFriendOrNot == 0){
                        return ReturnMsg.build(200,"0",userVO);
                  }
                  if (isFriendOrNot == 1){
                        return ReturnMsg.build(200,"1",userVO);
                  }
                  if (isFriendOrNot == 2){
                        return ReturnMsg.build(200,"2",userVO);
                  }

            }
            return ReturnMsg.err("该用户不存在！");
      }
}
