package service.impl;

import mapper.RoleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.RoleInfo;
import service.RoleInfoService;

import java.util.List;

@Service
public class RoleInfoServiceImpl implements RoleInfoService{

    @Autowired
    public RoleInfoMapper roleInfoMapper;
    @Override
    public List<RoleInfo> listAllRole() {
        return roleInfoMapper.listRole();
    }

    @Override
    public List<RoleInfo> getRoleByParam(RoleInfo roleInfo) {
        return roleInfoMapper.getRoleByParam(roleInfo);
    }

    @Override
    public int insertRole(int roleId, String roleName) {
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleId(roleId);
        roleInfo = roleInfoMapper.getRoleByParam(roleInfo).get(0);
        if(roleInfo.getRoleName().equals(roleName)){
            return 0;
        }else {
            roleInfo.setRoleName(roleName);
            return roleInfoMapper.insert(roleInfo);
        }

    }

    @Override
    public int deleteRole(int roleId) {
        return roleInfoMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public int updateRole(int roleId, String roleName) {
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleId(roleId);
        roleInfo.setRoleName(roleName);
        return roleInfoMapper.updateByPrimaryKey(roleInfo);
    }


}
