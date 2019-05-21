package com.bzhang.xialiao.service;

import com.bzhang.xialiao.pojo.ScFriendsRequest;

/**
 * Created by bzhang on 2019/5/20.
 */
public interface ScFriendsRequestService {
    /**
     * 新增好友请求
     * @param request
     * @return
     */
    int insertFriendRequest(ScFriendsRequest request);

}
