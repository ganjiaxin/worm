package com.data.mapper;

import com.data.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KeyLibraryMapper extends BaseMapper {

    @Select("select id from key_library where key_name = #{keyName}")
    Integer selectKeyLibrary(@Param("keyName") String keyName);

    @Insert("insert into key_library set key_name = #{keyName}")
    Integer insertKeyLibrary(@Param("keyName") String keyName);
}
