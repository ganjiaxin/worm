package com.data.service;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONArray;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONObject;
import com.data.entity.KeyWord;
import com.data.entity.Track;
import com.data.mapper.TrackMapper;
import com.data.utils.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : ganjiaxin
 * create at:  2018/12/22  12:34 PM
 * @description:
 */

@Service("trackService")
public class TrackService {
    @Autowired
    TrackMapper trackMapper;

    /**
     * 更新应用
     *
     * @return
     */
    @Transactional
    public void replaceTrack(JSONArray jsonArray) {
        Date addTime = DateUtils.getNow();
        List<Track> list = new ArrayList<Track>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Integer n = trackMapper.selectTrack(jsonObject.getInteger("trackId"), jsonObject.getString("trackViewUrl"));
            if (n > 0) {
                trackMapper.updateTrack(jsonObject.getInteger("trackId"), jsonObject.getString("trackName"),
                        jsonObject.getString("trackContentRating"), jsonObject.getString("trackViewUrl"),
                        jsonObject.getString("trackCensoredName"), jsonObject.getInteger("artistId"),
                        jsonObject.getString("primaryGenreName"), jsonObject.getInteger("primaryGenreId"),
                        jsonObject.getString("kind"), addTime);
            } else {
                trackMapper.insertTrack(jsonObject.getInteger("trackId"), jsonObject.getString("trackName"),
                        jsonObject.getString("trackContentRating"), jsonObject.getString("trackViewUrl"),
                        jsonObject.getString("trackCensoredName"), jsonObject.getInteger("artistId"),
                        jsonObject.getString("primaryGenreName"), jsonObject.getInteger("primaryGenreId"),
                        jsonObject.getString("kind"), addTime);
            }
        }

    }
}
