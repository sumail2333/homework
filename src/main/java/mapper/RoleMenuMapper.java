package mapper;

import pojo.RoleMenu;
import pojo.RoleMenuBean;

import java.util.List;

public interface RoleMenuMapper {
    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    List<RoleMenuBean> listRoleMenu();

    List<RoleMenuBean> getRoleMenuByParam(RoleMenuBean roleMenuBean);

    int updateByRoleId(RoleMenu roleMenu);

    int deleteByMenuIdAndRoleId(RoleMenu roleMenu);
}