package com.bzhang.xialiao.service;

import com.bzhang.xialiao.pojo.ScUsers;

/**
 * 用户服务层
 * Created by bzhang on 2019/5/9.
 */
public interface ScUsersService {
      /**
       * 判断用户是否存在
       * @param user
       * @return
       */
      boolean queryUsernameIsExist(ScUsers user);

      /**
       * 根据用户名密码，验证用户是否存在，用户登录
       * @param user
       * @return
       */
      ScUsers selectUserByUsernameAndPwd(ScUsers user);

      /**
       * 用于用户注册
       * @param user
       * @return
       */
      int addUser(ScUsers user);

      /**
       * 更新用户信息
       * @param user
       * @return
       */
      int updateUserById(ScUsers user);

      /**
       * 根据用户id选择用户
       * @param id
       * @return
       */
      ScUsers selectUserById(String id);
}
