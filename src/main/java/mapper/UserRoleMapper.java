package mapper;

import pojo.UserRole;
import pojo.UserRoleJoin;

import java.util.List;

import java.util.List;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectBuUserId(String userId);


    List<UserRoleJoin> listUserRole();

    List<UserRoleJoin> getUserRoleByParam(UserRoleJoin userRoleJoin);

    int updateByUserId(UserRole userRole);

    int deleteByUserIdAndRoleId(UserRole userRole);
}