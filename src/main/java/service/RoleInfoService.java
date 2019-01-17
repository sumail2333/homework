package service;

import pojo.RoleInfo;

import java.util.List;

public interface RoleInfoService {

    public List<RoleInfo> listAllRole();

    public List<RoleInfo> getRoleByParam(RoleInfo roleInfo);

    public int updateRole(int roleId,String roleName);

    public int insertRole(int roleId,String roleName);

    public int deleteRole(int roleId);
}
