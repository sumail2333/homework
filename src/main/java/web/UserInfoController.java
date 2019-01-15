package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pojo.UserInfo;
import service.UserInfoService;

import javax.annotation.Resource;

@Controller
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

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
}
