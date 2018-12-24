package com.data.service;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONArray;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONObject;
import com.data.entity.KeyWord;
import com.data.entity.Track;
import com.data.mapper.TrackMapper;
import com.data.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : ganjiaxin
 * create at:  2018/12/22  12:34 PM
 * @description:
 */

@Service
public class TrackService {
    @Autowired
    TrackMapper trackMapper;

    /**
     * @return
     */
    public Integer replaceTrack(JSONArray jsonArray) {
        Date addTime = DateUtils.getNow();
        List<Track> list = new ArrayList<Track>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Integer position = i + 1;
            Track track = new Track();
            track.setTrackId(jsonObject.getInteger("trackId"));
            track.setName(jsonObject.getString("trackName"));
            track.setContentRating(jsonObject.getString("trackContentRating"));
            track.setViewUrl(jsonObject.getString("trackViewUrl"));
            track.setCensoredName(jsonObject.getString("trackCensoredName"));
            track.setArtistId(jsonObject.getInteger("trackId"));
            track.setPrimaryGenreName(jsonObject.getString("primaryGenreId"));
            track.setPrimaryGenreName(jsonObject.getString("primaryGenreName"));
            track.setKind(jsonObject.getString("kind"));
            track.setAddTime(addTime);
            list.add(track);
        }
        Integer i = trackMapper.batchreplaceTrack(list);
        return i;
    }
}
