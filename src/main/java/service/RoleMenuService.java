package service;

import pojo.RoleMenuBean;


import java.util.List;

public interface RoleMenuService {

    public List<RoleMenuBean> listAllRoleMenu();

    public List<RoleMenuBean> getRoleMenuByParam(RoleMenuBean roleMenuBean);

    public int updateRoleMenu(int roleId, int menuId);

    public int insertRoleMenu(int roleId, int menuId);

    public int deleteRoleMenu(int roleId, int menuId);
}
