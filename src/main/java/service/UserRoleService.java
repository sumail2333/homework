package service;

import pojo.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> selectBuUserId(String userId);
    int insertSelective(UserRole record);

}
