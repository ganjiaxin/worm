package com.data.mapper;

import com.data.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;

@Mapper
public interface UserMapper {

    @Select("SELECT * from user WHERE mobile = #{userName} or user_name # {userName}")
    User selectUserUserNameOrMobile(@Param("userName") String userName);

    @Select("SELECT * from user WHERE mobile = #{mobile}")
    User selectUserMobile(@Param("mobile") String mobile);

    @Select("SELECT * from user WHERE id = #{id}")
    User selectByKey(@Param("id") int id);

    @Select("SELECT * from user WHERE mobile = #{mobile} or email = #{mobile}")
    User selectUserMobileOrEmail(@Param("mobile") String mobile);

    @Select("SELECT * from user WHERE invitation_code = #{invitation_code}")
    User findByInvitationCode(@Param("invitation_code") String invitation_code);

    @Insert("insert into  login_log(login_device,login_ip,login_time,uid) VALUES()")
    void save(User user);

    @Insert("insert into  user(salt,nick_name,password,mobile,add_time,add_ip,invitation_code) VALUES( #{salt}," +
            "#{nickName},#{hexPassword},#{mobile},#{add_time},#{addIp},#{invitation_code})")
    int saveByPhone(@Param("salt") String salt, @Param("nickName") String userName,
                     @Param("hexPassword") String hexPassword, @Param("mobile") String mobile,
                     @Param("add_time") Date add_time, @Param("addIp") String addIp,
                     @Param("invitation_code") String invitation_code);

    @Insert("insert into  user(salt,nick_name,password,email,add_time,add_ip,invitation_code) VALUES( #{salt}," +
            "#{nickName},#{hexPassword},#{email},#{add_time},#{addIp},#{invitation_code})")
    int saveByEmail(@Param("salt") String salt, @Param("nickName") String userName,
                     @Param("hexPassword") String hexPassword, @Param("email") String email,
                     @Param("add_time") Date add_time, @Param("addIp") String addIp,
                     @Param("invitation_code") String invitation_code);

    @Select("SELECT * from user WHERE email = #{email}")
    User selectUserEmail(@Param("email") String email);

    @Update("UPDATE user SET password = #{password} WHERE mobile = #{mobile}")
    int updateUesrPassword(@Param("password") String password, @Param("mobile") String mobile);


    @Select("SELECT count(*) from user WHERE add_time  between #{day1} and #{day2}")
    int getOneDayRegist(@Param("day1") String day1s, @Param("day2") String day2s);

//    @Select("select * from user a order by a.add_time desc limit #{pageNo},#{pageSize} ")
//    List<UserReturn> findPage(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
}
