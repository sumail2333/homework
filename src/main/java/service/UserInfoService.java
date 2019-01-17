package service;

import pojo.UserInfo;

public interface UserInfoService {
    UserInfo selectByPrimaryKey(String userId);
    UserInfo selectByUsernameAndPassword(String username,String password);
    UserInfo selectByUserName(String username);
    int insertSelective(UserInfo record);
}
