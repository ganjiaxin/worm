package com.data.mapper;


import com.data.batch.BaseBatch;
import com.data.entity.KeyWord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface KeyWordMapper {


    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    @InsertProvider(type = BaseBatch.class, method = "batchAdd")
    Integer batchInsertKeyWord(List<KeyWord> list);

    /**
     * 单条插入
     *
     * @param keyName
     * @param trackId
     * @param ranking
     * @param region
     * @param addTime
     * @param updateTime
     * @param keyId
     * @param state
     * @return
     */
    @Insert("insert into key_word(key_name,track_id,ranking,region,add_time,update_time,key_id,state)values" +
            "(#{keyName},#{trackId},#{ranking},#{region},#{addTime},#{updateTime},#{keyId},#{state})")
    Integer insertKeyWord(@Param("keyName") String keyName, @Param("trackId") Integer trackId,
                          @Param("ranking") Integer ranking, @Param("region") String region,
                          @Param("addTime") Date addTime, @Param("updateTime") Date updateTime,
                          @Param("keyId") Integer keyId, @Param("state") Integer state);
}
