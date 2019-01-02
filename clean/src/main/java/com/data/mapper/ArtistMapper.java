package com.data.mapper;

import com.data.batch.BaseBatch;
import com.data.entity.Artist;
import com.data.entity.KeyLibrary;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface ArtistMapper {

    @Insert("insert into  artist(name,view_url,artist_id,add_time) values(#{name},#{viewUrl},#{artistId},#{addTime}) ")
    Integer insertArtist(@Param("artistId") Integer artistId, @Param("name") String name,
                         @Param("viewUrl") String viewUrl, @Param("addTime") Date addTime);


    @Update("update artist set name = #{name} ,  view_url = #{viewUrl} where artist_id = #{artistId} ")
    Integer updateArtist(@Param("artistId") Integer artistId, @Param("name") String name,
                         @Param("viewUrl") String viewUrl);

    @Select("select count(*) from artist  where   artist_id = #{artistId} ")
    Integer selectArtist(@Param("artistId") Integer artistId);
}
