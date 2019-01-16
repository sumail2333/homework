package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pojo.MenuInfo;
import service.MenuInfoService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("opt")
public class MenuController {
    @Resource
    private MenuInfoService menuInfoService;
    @RequestMapping(value = "/list")
    @ResponseBody
    public ModelAndView selectAllMenuItem(ModelMap modelMap){
        List<MenuInfo> menuInfos = menuInfoService.selectAllMenuItem();
        ModelAndView m = new ModelAndView("list");
        m.addObject("opts",menuInfos);
        return m;
    }

    @RequestMapping(value = "/edit")
    @ResponseBody
    public ModelAndView edit(ModelMap modelMap){
        List<MenuInfo> menuInfos = menuInfoService.selectAllMenuItem();
        ModelAndView m = new ModelAndView("listManage");
        m.addObject("opts",menuInfos);
        return m;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST, consumes = {"application/json","application/x-www-form-urlencoded"})
    @ResponseBody
    public int create(@RequestBody MenuInfo menuInfo,ModelAndView m){
        System.out.println(menuInfo.getName());
        int i = menuInfoService.insertSelective(menuInfo);
        return i;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST, consumes = {"application/json","application/x-www-form-urlencoded"})
    @ResponseBody
    public int delete(@RequestBody MenuInfo menuInfo,ModelAndView m){
        int i = menuInfoService.deleteByPrimaryKey(menuInfo.getId());
        return i;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST, consumes = {"application/json","application/x-www-form-urlencoded"})
    @ResponseBody
    public int update(@RequestBody MenuInfo menuInfo,ModelAndView m){
        int i = menuInfoService.updateByPrimaryKeySelective(menuInfo);
        return i;
    }
}
