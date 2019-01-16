package service;

import pojo.MenuInfo;

import java.util.List;

public interface MenuInfoService {
    List<MenuInfo> selectAllMenuItem();
    int insertSelective(MenuInfo m);
    int deleteByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(MenuInfo record);
}
