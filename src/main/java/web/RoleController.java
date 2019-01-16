package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.RoleInfo;
import service.RoleInfoService;

import java.util.List;
import java.util.Map;

@Controller
public class RoleController {
    @Autowired
    public RoleInfoService roleInfoService;

    @RequestMapping(value = "listRole",method = RequestMethod.GET)
    @ResponseBody
    public List<RoleInfo> searchRoles(@RequestParam String roleID, @RequestParam String roleName ){
        RoleInfo roleInfo = new RoleInfo();
        if(roleID == null && roleName ==null){
            return roleInfoService.listAllRole();
        }else {
            roleInfo.setRoleId(Integer.valueOf(roleID));
            roleInfo.setRoleName(roleName);
            return roleInfoService.getRoleByParam(roleInfo);
        }

    }

    @RequestMapping(value = "updateRole",method = RequestMethod.POST)
    public int updateRole(@RequestBody Map map){
        int roleId = Integer.parseInt((String)map.get("roleId"));
        String roleName = (String)map.get("roleName");
        return roleInfoService.updateRole(roleId,roleName);

    }
    @RequestMapping(value = "insertRole",method = RequestMethod.POST)
    public int insertRole(@RequestBody Map map){
        int roleId = Integer.parseInt((String)map.get("roleId"));
        String roleName = (String)map.get("roleName");
        return roleInfoService.insertRole(roleId,roleName);

    }
    @RequestMapping(value = "deleteRole",method = RequestMethod.GET)
    public int deleteRole(@RequestParam String roleId){
        return roleInfoService.deleteRole(Integer.parseInt(roleId));
    }
}
