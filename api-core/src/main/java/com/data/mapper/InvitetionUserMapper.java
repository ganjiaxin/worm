package com.data.mapper;

import com.data.entity.InvitetionUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface InvitetionUserMapper {

    @Insert("insert into  invitetion_user(add_time,user_id,invitee_id) VALUES( #{addTime},#{userId},#{inviteeId})")
    void save(@Param("addTime") Date addTime, @Param("userId") Integer userId, @Param("inviteeId") Integer inviteeId);

    //自己邀请的用户列表
    @Select("select * from invitetion_user t1,user t2 where t1.user_id=#{userId} and t2.id=t1.invitee_id")
    List<InvitetionUser> selectInvitetionUserListByUserId(@Param("userId") Integer userId);

    //邀请自己的用户
    @Select("select * from invitetion_user t1,user t2 where t1.invitee_id=#{userId} and t2.id=t1.user_id")
    InvitetionUser selectInvitetionUserByUserId(@Param("userId") Integer userId);
}
