package com.bzhang.xialiao.service;

import com.bzhang.xialiao.pojo.ScFriendsRequest;

import java.util.List;

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

    /**
     * 根据给定的条件查找对应的请求,可以是请求id或发送者id
     * 或接受者id
     * @param request
     * @return
     */
    List<ScFriendsRequest> selectRequestById(ScFriendsRequest request);

    /**
     * 处理好友请求，同意需要添加我的好友表内容
     * @param scFriendsRequest
     * @return
     */
    boolean updateRequestIsHandle(ScFriendsRequest scFriendsRequest);

}
