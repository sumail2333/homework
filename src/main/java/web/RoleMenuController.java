package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.RoleMenuBean;
import service.RoleMenuService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("roleMenu")
public class RoleMenuController {

    @Autowired
    public RoleMenuService roleMenuService;

    @RequestMapping(value = "listRoleMenu", method = RequestMethod.GET)
    @ResponseBody
    public List<RoleMenuBean> listRoleMenu(@RequestParam String roleId,@RequestParam String menuId,@RequestParam String roleName,@RequestParam String menuName){
        RoleMenuBean roleMenuBean = new RoleMenuBean();
        if(roleId == null && menuId == null && roleName ==null && menuName == null){
            return roleMenuService.listAllRoleMenu();
        }else {
            roleMenuBean.setRoleId(Integer.parseInt(roleId));
            roleMenuBean.setMenuId(Integer.valueOf(menuId));
            roleMenuBean.setRoleName(roleName);
            roleMenuBean.setMenuName(menuName);
            return roleMenuService.getRoleMenuByParam(roleMenuBean);
        }
    }

    @RequestMapping(value = "updateRoleMenu",method = RequestMethod.POST)
    public int updateRoleMenu(@RequestBody Map map){
        int roleId = Integer.parseInt((String)map.get("roleId"));
        int menuId = Integer.valueOf((String)map.get("menuId"));
        return roleMenuService.updateRoleMenu(roleId,menuId);
    }

    @RequestMapping(value = "insertRoleMenu",method = RequestMethod.POST)
    public int insertRoleMenu(@RequestBody Map map){
        int roleId = Integer.parseInt((String)map.get("roleId"));
        int menuId = Integer.valueOf((String)map.get("menuId"));
        return roleMenuService.insertRoleMenu(roleId,menuId);
    }

    @RequestMapping(value = "deleteRoleMenu",method = RequestMethod.POST)
    public int deleteRoleMenu(@RequestBody Map map){
        int roleId = Integer.parseInt((String)map.get("roleId"));
        int menuId = Integer.valueOf((String)map.get("menuId"));
        return roleMenuService.deleteRoleMenu(roleId,menuId);
    }


}
