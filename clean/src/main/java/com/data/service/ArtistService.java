package com.data.service;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONArray;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONObject;
import com.data.entity.Artist;
import com.data.mapper.ArtistMapper;
import com.data.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : ganjiaxin
 * create at:  2018/12/27  2:14 PM
 * @description:
 */
@Service("artistService")
public class ArtistService {
    @Autowired
    ArtistMapper artistMapper;

    /**
     * 更新发行商
     *
     * @param array
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void replaceArtist(JSONArray array) {
        List<Artist> list = new ArrayList<Artist>();
        Date addTime = DateUtils.getNow();
        for (Object o : array) {
            JSONObject object = JSON.parseObject(JSON.toJSONString(o));
            Integer n = artistMapper.selectArtist(object.getInteger("artistId"));
            if (n > 0) {
                artistMapper.updateArtist(object.getInteger("artistId"), object.getString("artistName"),
                        object.getString("artistViewUrl"));
            } else {
                artistMapper.insertArtist(object.getInteger("artistId"), object.getString("artistName"),
                        object.getString("artistViewUrl"), addTime);
            }
        }
    }
}
