package service.impl;

import mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.UserRole;
import pojo.UserRoleJoin;
import service.UserRoleService;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public List<UserRole> selectBuUserId(String userId) {
        return userRoleMapper.selectBuUserId(userId);
    }

    @Override
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }

    @Override
    public List<UserRoleJoin> listAllUserRole() {
        return userRoleMapper.listUserRole();
    }

    @Override
    public List<UserRoleJoin> getUserRoleByParam(UserRoleJoin userRoleJoin) {
        return userRoleMapper.getUserRoleByParam(userRoleJoin);
    }

    @Override
    public int updateUserRole(int roleId, String userId) {
        UserRoleJoin userRoleJoin = new UserRoleJoin();
        userRoleJoin.setUserId(userId);
        List<UserRoleJoin> userRoleJoinList = userRoleMapper.getUserRoleByParam(userRoleJoin);
        for(UserRoleJoin userRoleJoin1 : userRoleJoinList){
            if(userRoleJoin1.getRoleId()== roleId){
                return 0;
            }
        }
        UserRole userRole = new UserRole();
        userRole.setRoleId(roleId);
        userRole.setUserId(userId);
        return userRoleMapper.updateByUserId(userRole);

    }

    @Override
    public int insertUserRole(int roleId, String userId) {
        UserRoleJoin userRoleJoin = new UserRoleJoin();
        userRoleJoin.setUserId(userId);
        List<UserRoleJoin> userRoleJoinList = userRoleMapper.getUserRoleByParam(userRoleJoin);
        for(UserRoleJoin userRoleJoin1 : userRoleJoinList){
            if(userRoleJoin1.getRoleId()== roleId){
                return 0;
            }
        }
        UserRole userRole = new UserRole();
        userRole.setRoleId(roleId);
        userRole.setUserId(userId);
        return userRoleMapper.insert(userRole);
    }

    @Override
    public int deleteUserRole(int roleId, String userId) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        return userRoleMapper.deleteByUserIdAndRoleId(userRole);
    }
}
