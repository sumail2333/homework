package mapper;

import pojo.MenuInfo;

import java.util.List;

public interface MenuInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuInfo record);

    int insertSelective(MenuInfo record);

    MenuInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuInfo record);

    int updateByPrimaryKey(MenuInfo record);

    List<MenuInfo> selectAllMenuItem();
}