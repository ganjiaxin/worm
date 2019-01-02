package com.data.mapper;

import com.data.batch.BaseBatch;
import com.data.entity.KeyWord;
import com.data.entity.Track;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface TrackMapper {


    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    @InsertProvider(type = BaseBatch.class, method = "batchAdd")
    Integer batchinsertTrack(List<Track> list);


    /**
     * 单条插入
     *
     * @param trackId
     * @param name
     * @param contentRating
     * @param viewUrl
     * @param censoredName
     * @param artistId
     * @param primaryGenreName
     * @param kind
     * @param updateTime
     * @return
     */
    @Insert("insert into track set track_id = #{trackId},name = #{name},content_rating = #{contentRating},view_url =" +
            " #{viewUrl}," +
            "censored_name = #{censoredName},artist_id = #{artistId},primary_genre_name = #{primaryGenreName}," +
            "primary_genre_id = #{primaryGenreId},kind = " +
            "#{kind}," +
            "update_time = #{updateTime} ")
    Integer insertTrack(@Param(value = "trackId") Integer trackId, @Param(value = "name") String name,
                        @Param(value = "contentRating") String contentRating, @Param(value = "viewUrl") String viewUrl,
                        @Param(value = "censoredName") String censoredName, @Param(value = "artistId") Integer artistId,
                        @Param(value = "primaryGenreName") String primaryGenreName,
                        @Param(value = "primaryGenreId") Integer primaryGenreId,
                        @Param(value = "kind") String kind, @Param(value = "updateTime") Date updateTime);

    /**
     * 单条更新
     *
     * @param trackId
     * @param name
     * @param contentRating
     * @param viewUrl
     * @param censoredName
     * @param artistId
     * @param primaryGenreName
     * @param kind
     * @param updateTime
     * @return
     */
    @Update("update track set name = #{name},content_rating = #{contentRating},view_url =" +
            " #{viewUrl}," +
            "censored_name = #{censoredName},artist_id = #{artistId}," +
            "primary_genre_id = #{primaryGenreId},kind = " +
            "#{kind}," +
            "update_time = #{updateTime}  where track_id = #{trackId} ")
    Integer updateTrack(@Param(value = "trackId") Integer trackId, @Param(value = "name") String name,
                        @Param(value = "contentRating") String contentRating, @Param(value = "viewUrl") String viewUrl,
                        @Param(value = "censoredName") String censoredName, @Param(value = "artistId") Integer artistId,
                        @Param(value = "primaryGenreName") String primaryGenreName,
                        @Param(value = "primaryGenreId") Integer primaryGenreId,
                        @Param(value = "kind") String kind, @Param(value = "updateTime") Date updateTime);

    /**
     * 单条查询
     *
     * @param trackId
     * @return
     */
    @Select("select count(*) from  track  where track_id = #{trackId} and view_url = #{viewUrl}")
    Integer selectTrack(@Param(value = "trackId") Integer trackId, @Param(value = "viewUrl") String viewUrl);
}
