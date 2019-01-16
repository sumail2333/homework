package service;

import pojo.RoleInfo;
import pojo.UserRoleJoin;

import java.util.List;

public interface UserRoleService {

    public List<UserRoleJoin> listAllUserRole();

    public List<UserRoleJoin> getUserRoleByParam(UserRoleJoin userRoleJoin);

    public int updateUserRole(int roleId, String userId);

    public int insertUserRole(int roleId, String userId);

    public int deleteUserRole(int roleId, String userId);
}
