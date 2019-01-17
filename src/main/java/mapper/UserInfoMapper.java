package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    UserInfo selectByUserName(String username);
}