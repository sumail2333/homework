package service.impl;

import mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.UserInfo;
import service.UserInfoService;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public UserInfo selectByPrimaryKey(String userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public UserInfo selectByUsernameAndPassword(String username, String password) {
        System.out.println("dddddddddddddddddddddd");
        return userInfoMapper.selectByUsernameAndPassword(username,password);
    }

    @Override
    public UserInfo selectByUserName(String username) {
        return userInfoMapper.selectByUserName(username);
    }

    @Override
    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }


}
