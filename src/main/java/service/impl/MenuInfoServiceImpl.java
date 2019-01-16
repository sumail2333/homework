package service.impl;

import mapper.MenuInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.MenuInfo;
import service.MenuInfoService;

import java.util.List;

@Service
public class MenuInfoServiceImpl implements MenuInfoService {
    @Autowired
    private MenuInfoMapper menuInfoMapper;
    @Override
    public List<MenuInfo> selectAllMenuItem() {
        return menuInfoMapper.selectAllMenuItem();
    }

    @Override
    public int insertSelective(MenuInfo m) {
        return menuInfoMapper.insertSelective(m);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return menuInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MenuInfo record) {
        return menuInfoMapper.updateByPrimaryKeySelective(record);
    }
}
