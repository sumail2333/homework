package service.impl;

import mapper.RoleMenuMapper;
import mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.RoleMenu;
import pojo.RoleMenuBean;
import pojo.UserRole;
import pojo.UserRoleJoin;
import service.RoleMenuService;
import service.UserRoleService;

import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    public RoleMenuMapper roleMenuMapper;


    @Override
    public List<RoleMenuBean> listAllRoleMenu() {
        return roleMenuMapper.listRoleMenu();
    }

    @Override
    public List<RoleMenuBean> getRoleMenuByParam(RoleMenuBean roleMenuBean) {
        return roleMenuMapper.getRoleMenuByParam(roleMenuBean);
    }

    @Override
    public int updateRoleMenu(int roleId, int menuId) {
        RoleMenuBean roleMenuBean = new RoleMenuBean();
        roleMenuBean.setRoleId(roleId);
        List<RoleMenuBean> roleMenuBeanList = roleMenuMapper.getRoleMenuByParam(roleMenuBean);
        for(RoleMenuBean roleMenuBean1 : roleMenuBeanList){
            if(roleMenuBean1.getMenuId()==menuId){
                return 0;
            }
        }
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setMenuId(menuId);
        roleMenu.setRoleId(roleId);
        return roleMenuMapper.updateByRoleId(roleMenu);
    }

    @Override
    public int insertRoleMenu(int roleId, int menuId) {
        RoleMenuBean roleMenuBean = new RoleMenuBean();
        roleMenuBean.setRoleId(roleId);
        List<RoleMenuBean> roleMenuBeanList = roleMenuMapper.getRoleMenuByParam(roleMenuBean);
        for(RoleMenuBean roleMenuBean1 : roleMenuBeanList){
            if(roleMenuBean1.getMenuId()==menuId){
                return 0;
            }
        }
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setMenuId(menuId);
        roleMenu.setRoleId(roleId);
        return roleMenuMapper.insert(roleMenu);
    }

    @Override
    public int deleteRoleMenu(int roleId, int menuId) {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRoleId(roleId);
        roleMenu.setMenuId(menuId);
        return roleMenuMapper.deleteByMenuIdAndRoleId(roleMenu);
    }
}
