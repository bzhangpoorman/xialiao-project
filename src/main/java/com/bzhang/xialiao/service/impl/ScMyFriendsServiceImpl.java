package com.bzhang.xialiao.service.impl;

import com.bzhang.xialiao.mapper.ScMyFriendsMapper;
import com.bzhang.xialiao.pojo.ScMyFriends;
import com.bzhang.xialiao.pojo.ScMyFriendsExample;
import com.bzhang.xialiao.service.ScMyFriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bzhang on 2019/5/20.
 */
@Service
public class ScMyFriendsServiceImpl implements ScMyFriendsService {

      @Autowired
      private ScMyFriendsMapper scMyFriendsMapper;

      @Override
      public int checkUserIsFriendOrNot(String userId, String friendId) {
            ScMyFriendsExample example =new ScMyFriendsExample();
            example.createCriteria().andMyUserIdEqualTo(userId).andFriendUserIdEqualTo(friendId);
            List<ScMyFriends> list = scMyFriendsMapper.selectByExample(example);
            if (list!=null&&list.size()>0){
                  if (list.get(0).getIsBlack()==0){
                        return 1;
                  }else {
                        return 2;
                  }
            }
            return 0;
      }
}
