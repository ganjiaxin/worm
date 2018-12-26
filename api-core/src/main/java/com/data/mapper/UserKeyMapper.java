package com.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserKeyMapper {

    @Select("SELECT uk.key_name,uk.key_id,uk.tack_id,kw.ranking FROM user_key" +
            " uk LEFT JOIN key_word kw ON uk.key_id = kw.key_id AND uk" +
            ".tack_id = kw.track_id WHERE uk.user_id = #{userId} ORDER BY kw" +
            ".update_time desc")
    Map selectUserKey(@Param(value = "userId") Integer userId);
}
