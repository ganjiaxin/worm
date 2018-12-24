package com.data.mapper;

import com.data.entity.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BannerMapper {

    @Select("select * from banner where type = #{type} and shows in(0, #{shows})")
    List<Banner> selectBannerByTypeAndShows(@Param("type") Integer type, @Param("shows") Integer shows);
}
