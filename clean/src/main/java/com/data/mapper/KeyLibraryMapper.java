package com.data.mapper;

import com.data.base.BaseMapper;
import com.data.batch.BaseBatch;
import com.data.entity.KeyLibrary;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface KeyLibraryMapper extends BaseMapper {

    @Select("select id from key_library where key_name = #{keyName}")
    Integer selectKeyLibrary(@Param("keyName") String keyName);

    @Insert("insert into key_library set key_name = #{keyName}")
    Integer insertKeyLibrary(@Param("keyName") String keyName);


    @InsertProvider(type = BaseBatch.class, method = "batchAdd")
    Integer batchinsertKeyLibrary(List<KeyLibrary> list);

    @Update("update key_library set fiery = #{fiery} ,update_time = #{updateTime} where  key_name = #{keyName}")
    Integer updateKeyLibrary(@Param("fiery") Integer fiert, @Param("keyName") String keyName,
                             @Param("updateTime") Date updateTime);
}
