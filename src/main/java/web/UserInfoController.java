package web;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pojo.UserInfo;
import pojo.UserRole;
import service.UserInfoService;
import service.UserRoleService;
import service.impl.UserRoleServiceImpl;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserRoleService userRoleService;
    @RequestMapping(value = "/user/userManage",method = RequestMethod.POST)
    public ModelAndView login(String username,String password, ModelMap model){

        UserInfo userInfo = userInfoService.selectByUsernameAndPassword(username,password);
        if(userInfo != null){
            ModelAndView m = new ModelAndView("userManage");
            model.addAttribute("userInfo",userInfo);
            m.addObject(model);
            return m;
        }else{
            ModelAndView m = new ModelAndView("index");
            model.addAttribute("msg","用户名密码错误！");
            m.addObject(model);
            return m;
        }
    }

    @RequestMapping(value = "/user/search",method = RequestMethod.POST, consumes = {"application/json","application/x-www-form-urlencoded"})
    @ResponseBody
    public Map<String,String> selectByUserName(@RequestBody UserInfo user, ModelAndView m) {
        UserInfo userInfo= userInfoService.selectByUserName(user.getUserName());
        Map<String,String> map = new HashMap<String,String>();
        map.put("userName",userInfo.getUserName());
        map.put("userId",userInfo.getUserId());
        List<UserRole> roles = userRoleService.selectBuUserId(userInfo.getUserId());
        List<Integer> arrayList = new ArrayList<Integer>();
        for(UserRole u :roles){
            arrayList.add(u.getRoleId());
        }
        map.put("list", StringUtils.join(arrayList,","));
        return map;
    }

    @RequestMapping(value = "/user/addNew",method = RequestMethod.POST,consumes = {"application/json","application/x-www-form-urlencoded"},produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public String addNew(@RequestBody Map<String,String> params) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(params.get("username"));
        userInfo.setPassword(params.get("password"));
        UserRole userRole = new UserRole();
        userRole.setRoleId(Integer.parseInt(params.get("roleId")));
        userInfoService.insertSelective(userInfo);
        String userId = userInfoService.selectByUsernameAndPassword(params.get("username"),params.get("password")).getUserId();
        userRole.setUserId(userId);
        userRoleService.insertSelective(userRole);
        return "新建成功！";
    }
}
