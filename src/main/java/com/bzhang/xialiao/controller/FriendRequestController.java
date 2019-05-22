package com.bzhang.xialiao.controller;

import com.bzhang.xialiao.pojo.ScFriendsRequest;
import com.bzhang.xialiao.service.ScFriendsRequestService;
import com.bzhang.xialiao.service.ScMyFriendsService;
import com.bzhang.xialiao.utils.ReturnMsg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @CreateTime 2019/5/21
 * @Autor bzhang
 **/
@RestController
@RequestMapping("/friend/request")
public class FriendRequestController {
    @Autowired
    private ScFriendsRequestService scFriendsRequestService;

    @Autowired
    private ScMyFriendsService scMyFriendsService;

    @PostMapping("/add")
    public ReturnMsg addFriendReqest(ScFriendsRequest scFriendsRequest){
        if (StringUtils.isBlank(scFriendsRequest.getAcceptUserId())|| StringUtils.isBlank(scFriendsRequest.getSendUserId())){
            return ReturnMsg.err("请求参数不正确！");
        }

        int res1 = scMyFriendsService.checkUserIsFriendOrNot(scFriendsRequest.getSendUserId(), scFriendsRequest.getAcceptUserId());
        int res2 = scMyFriendsService.checkUserIsFriendOrNot(scFriendsRequest.getAcceptUserId(),scFriendsRequest.getSendUserId());

        //判断是不是好友或者黑明单
        if (res1 == 0){
            scFriendsRequestService.insertFriendRequest(scFriendsRequest);
            return ReturnMsg.ok("请求发送成功");
        }else if (res1 == 1){
            return ReturnMsg.ok("你们已经是好友了！");
        }else if (res2 == 2){
            return ReturnMsg.ok("你已经被对方拉入黑名单，不能发送好友请求！");
        }
        return  ReturnMsg.err("错误的请求！");
    }

    @PostMapping("/search")
    public ReturnMsg searchAllrequest(ScFriendsRequest scFriendsRequest){
        if (StringUtils.isBlank(scFriendsRequest.getSendUserId())){
            return ReturnMsg.err("参数不正确！");
        }
        List<ScFriendsRequest> list = scFriendsRequestService.selectRequestById(scFriendsRequest);

        return ReturnMsg.ok(list);

    }



    @PostMapping("/handle")
    public ReturnMsg handleRequest(ScFriendsRequest scFriendsRequest){
        if (StringUtils.isBlank(scFriendsRequest.getId()) ||
            StringUtils.isBlank(scFriendsRequest.getSendUserId()) ||
            StringUtils.isBlank(scFriendsRequest.getAcceptUserId()) ||
            scFriendsRequest.getIsHandle()>0){
            return ReturnMsg.err("参数错误！");
        }

        scFriendsRequestService.

    }

}