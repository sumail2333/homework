package service;


import pojo.UserRole;

import pojo.RoleInfo;
import pojo.UserRoleJoin;

import java.util.List;

public interface UserRoleService {
    List<UserRole> selectBuUserId(String userId);
    int insertSelective(UserRole record);

    public List<UserRoleJoin> listAllUserRole();

    public List<UserRoleJoin> getUserRoleByParam(UserRoleJoin userRoleJoin);

    public int updateUserRole(int roleId, String userId);

    public int insertUserRole(int roleId, String userId);

    public int deleteUserRole(int roleId, String userId);
}
