package net.panda.user.mapper;

import net.panda.thrift.user.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select id, username, password, real_name as realName," +
            "mobile, email from pe_user where id=#{id}")
    UserInfo getUserById(@Param("id")int id);

    @Select("select id, username, password, real_name as realName," +
            "mobile, email from pe_user where username=#{username}")
    UserInfo getUserByUsername(@Param("username")String username);

    @Insert("insert into pe_user (username, password, real_name, mobile, email)" +
    "values (#{u.username}, #{u.password}, #{u.realName}, #{u.mobile}, #{u.email})")
    void registerUser(@Param("u") UserInfo userInfo);
}
