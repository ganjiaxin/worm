package com.data.mapper;

import com.data.batch.BaseBatch;
import com.data.entity.KeyWord;
import com.data.entity.Track;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface TrackMapper {


    /**
     * 批量刷新
     * @param list
     * @return
     */
    @InsertProvider(type = BaseBatch.class, method = "batchReplace")
    Integer batchreplaceTrack(List<Track> list);


    @Insert("replace into track set track_id = #{trackId},name = #{name},content_rating = #{contentRating},view_url =" +
            " #{viewUrl}," +
            "censored_name = #{censoredName},artist_id = #{artistId},primary_genre_name = #{primaryGenreName},kind = " +
            "#{kind}," +
            "update_time = #{updateTime} ")
    Integer replaceTrack(@Param(value = "trackId") Integer trackId, @Param(value = "name") String name,
                         @Param(value = "contentRating") String contentRating, @Param(value = "viewUrl") String viewUrl,
                         @Param(value = "censoredName") String censoredName, @Param(value = "artistId") String artistId,
                         @Param(value = "primaryGenreName") String primaryGenreName,
                         @Param(value = "kind") String kind, @Param(value = "updateTime") Date updateTime);
}
