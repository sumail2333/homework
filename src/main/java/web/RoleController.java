package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.RoleInfo;
import service.RoleInfoService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    public RoleInfoService roleInfoService;

    @RequestMapping(value = "routeToRole")
    public ModelAndView routeToRole(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("roleManagement");
        List<RoleInfo> roleInfos = roleInfoService.listAllRole();
        modelAndView.addObject("roleInfo",roleInfos);
        return modelAndView;

    }

    @RequestMapping(value = "listRole",method = RequestMethod.GET)
    @ResponseBody
    public List<RoleInfo> searchRoles(@RequestParam String roleID, @RequestParam String roleName ){
        RoleInfo roleInfo = new RoleInfo();
        if(roleID == "" && roleName ==""){
            return roleInfoService.listAllRole();
        }else {
            if(roleID!=""){
                roleInfo.setRoleId(Integer.valueOf(roleID));
            }
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
