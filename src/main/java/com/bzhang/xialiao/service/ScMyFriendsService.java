package com.bzhang.xialiao.service;

/**
 * Created by bzhang on 2019/5/20.
 */
public interface ScMyFriendsService {
      /**
       * 确定是否是好友关系
       * 返回值：
       * 0：不是好友
       * 1：是好友
       * 2：黑名单
       * @param userId
       * @param friendId
       * @return
       */
      int checkUserIsFriendOrNot(String userId,String friendId);
}
