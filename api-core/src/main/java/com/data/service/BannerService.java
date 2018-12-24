package com.data.service;

import com.data.entity.Banner;
import com.data.enums.BannerShowsEnum;
import com.data.mapper.BannerMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ganjiaxin
 * create at:  2018/12/13  12:36 PM
 * @description:
 */
@Service("bannerService")
public class BannerService {
    @Autowired
    BannerMapper bannerMapper;

    /**
     * 查询广告轮播图
     *
     * @param type
     * @param shows
     * @return
     */
    public List<Banner> selectBannerByTypeAndShows(Integer type, String shows) {
        List<Banner> bannerList = bannerMapper.selectBannerByTypeAndShows(type, StringUtils.isNotBlank(shows) ?
                BannerShowsEnum.getIndex(shows) : 0);
        return bannerList;

    }
}
