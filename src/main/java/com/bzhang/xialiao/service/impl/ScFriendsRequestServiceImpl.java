package com.bzhang.xialiao.service.impl;

import com.bzhang.xialiao.mapper.ScFriendsRequestMapper;
import com.bzhang.xialiao.mapper.ScMyFriendsMapper;
import com.bzhang.xialiao.pojo.ScFriendsRequest;
import com.bzhang.xialiao.pojo.ScFriendsRequestExample;
import com.bzhang.xialiao.pojo.ScMyFriends;
import com.bzhang.xialiao.service.ScFriendsRequestService;
import com.bzhang.xialiao.service.ScMyFriendsService;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by bzhang on 2019/5/20.
 */
@Service
public class ScFriendsRequestServiceImpl implements ScFriendsRequestService {
    @Autowired
    private ScMyFriendsMapper scMyFriendsMapper;

    @Autowired
    private ScFriendsRequestMapper scFriendsRequestMapper;

    @Autowired
    private Sid sid;

    @Transactional
    @Override
    public int insertFriendRequest(ScFriendsRequest request) {
        ScFriendsRequestExample example = new ScFriendsRequestExample();
        example.createCriteria().andSendUserIdEqualTo(request.getSendUserId()).andAcceptUserIdEqualTo(request.getAcceptUserId());

        List<ScFriendsRequest> list = scFriendsRequestMapper.selectByExample(example);

        //判断请求是否已经存在且已经处理过，只有请求已被处理过或者没发送过好友请求才会向对方发送好友请求
        if (list!=null&&list.size()>0){
            if (list.get(0).getIsHandle()==0){
                return 0;

            }
        }
        request.setId(sid.nextShort());
        request.setRequestDatetime(new Date());
        return scFriendsRequestMapper.insertSelective(request);
    }

    @Transactional
    @Override
    public List<ScFriendsRequest> selectRequestById(ScFriendsRequest request) {
        ScFriendsRequestExample example = new ScFriendsRequestExample();
        ScFriendsRequestExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNoneBlank(request.getSendUserId())){
            criteria.andSendUserIdEqualTo(request.getSendUserId());
        }
        if (StringUtils.isNoneBlank(request.getAcceptUserId())){
            criteria.andAcceptUserIdEqualTo(request.getAcceptUserId());
        }
        if (StringUtils.isNoneBlank(request.getId())){
            criteria.andIdEqualTo(request.getId());
        }

        List<ScFriendsRequest> list = scFriendsRequestMapper.selectByExample(example);
        return list;
    }

    @Transactional
    @Override
    public boolean updateRequestIsHandle(ScFriendsRequest scFriendsRequest) {
        ScFriendsRequestExample example = new ScFriendsRequestExample();
        example.createCriteria().andIdEqualTo(scFriendsRequest.getId());
        int res = scFriendsRequestMapper.updateByExampleSelective(scFriendsRequest, example);
        if (res == 1){
            if (scFriendsRequest.getIsHandle()==1){
                ScMyFriends sendUser = new ScMyFriends();
                sendUser.setMyUserId(scFriendsRequest.getSendUserId());
                sendUser.setFriendUserId(scFriendsRequest.getAcceptUserId());

                res =res + scMyFriendsMapper.insert(sendUser);
                if (res ==2)
            }
        }

    }
}
