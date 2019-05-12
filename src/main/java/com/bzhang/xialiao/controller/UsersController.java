package com.bzhang.xialiao.controller;

import com.bzhang.xialiao.pojo.ScUsers;
import com.bzhang.xialiao.pojo.vo.ScUsersVO;
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
}
