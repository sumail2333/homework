package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.RoleInfo;
import pojo.RoleMenuBean;
import pojo.UserRoleJoin;
import service.RoleInfoService;
import service.UserRoleService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("userRole")
public class UserRoleController {
    @Autowired
    public UserRoleService userRoleService;

    @RequestMapping(value = "routeToUserRole")
    public ModelAndView routeToUserRole(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("roleManagement");
        List<UserRoleJoin> roleMenuBeanList = userRoleService.listAllUserRole();
        modelAndView.addObject("roleMenuBeanList",roleMenuBeanList);
        return modelAndView;

    }

    @RequestMapping(value = "listUserRole",method = RequestMethod.GET)
    @ResponseBody
    public List<UserRoleJoin> searchUserRole(@RequestParam String roleID, @RequestParam String roleName ,@RequestParam String userId,@RequestParam String userName){
        UserRoleJoin userRoleJoin = new UserRoleJoin();
        if(roleID == "" && roleName =="" && userId == "" && userName ==""){
            return userRoleService.listAllUserRole();
        }else {
            userRoleJoin.setRoleId(Integer.valueOf(roleID));
            userRoleJoin.setRoleName(roleName);
            userRoleJoin.setUserId(userId);
            userRoleJoin.setUserName(userName);
            return userRoleService.getUserRoleByParam(userRoleJoin);
        }

    }

    @RequestMapping(value = "updateUserRole",method = RequestMethod.POST)
    public int updateRole(@RequestBody Map map){
        int roleId = Integer.parseInt((String)map.get("roleId"));
        String userId = (String)map.get("userId");
        return userRoleService.updateUserRole(roleId,userId);

    }
    @RequestMapping(value = "insertUserRole",method = RequestMethod.POST)
    public int insertRole(@RequestBody Map map){
        int roleId = Integer.parseInt((String)map.get("roleId"));
        String userId = (String)map.get("userId");
        return userRoleService.insertUserRole(roleId,userId);

    }
    @RequestMapping(value = "deleteUserRole",method = RequestMethod.GET)
    public int deleteRole(@RequestParam String roleId,@RequestParam String userId){

        return userRoleService.deleteUserRole(Integer.valueOf(roleId),userId);
    }
}
