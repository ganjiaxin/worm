package com.data.service;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONArray;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONObject;
import com.data.entity.SearchSoftware;
import com.data.mapper.SearchSoftwareMapper;
import com.data.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author : ganjiaxin
 * create at:  2018/12/20  9:58 PM
 * @description:
 */
@Service
public class SearchSoftwareService {

    @Autowired
    SearchSoftwareMapper searchSoftwareMapper;


    public int insertSearchSoftware(String term, String array) {
        Integer num = 0;
        JSONArray jsonArray = JSONArray.parseArray(array);
        Date addTime = DateUtils.getNow();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Integer position = i + 1;
            SearchSoftware searchSoftware = new SearchSoftware();
            searchSoftware.setTerm(term);
            num = searchSoftwareMapper.insertSearchSoftware(term,
                    jsonObject.getString("ipadScreenshotUrls"),
                    jsonObject.getString("artworkUrl60"),
                    jsonObject.getString("screenshotUrls"),
                    jsonObject.getString("appletvScreenshotUrls"),
                    jsonObject.getString("artworkUrl512"),
                    jsonObject.getString("artworkUrl100"), jsonObject.getString("artistViewUrl"),
                    jsonObject.getString("supportedDevices"), jsonObject.getString("advisories"),
                    jsonObject.getString("isGameCenterEnabled"), jsonObject.getString("kind"),
                    jsonObject.getString("features"),
                    jsonObject.getString("averageUserRatingForCurrentVersion"),
                    jsonObject.getString("trackCensoredName"),
                    jsonObject.getString("languageCodesISO2A"), jsonObject.getString("fileSizeBytes"),
                    jsonObject.getString("contentAdvisoryRating"),
                    jsonObject.getString("userRatingCountForCurrentVersion"),
                    jsonObject.getString("trackViewUrl"), jsonObject.getString("trackContentRating"),
                    jsonObject.getString("releaseNotes"), jsonObject.getString("trackName"),
                    jsonObject.getString("formattedPrice"), jsonObject.getString("primaryGenreId"),
                    jsonObject.getString("isVppDeviceBasedLicensingEnabled"),
                    jsonObject.getString("sellerName"), jsonObject.getString("currency"),
                    jsonObject.getString("wrapperType"), jsonObject.getString("version"),
                    jsonObject.getString("minimumOsVersion"), jsonObject.getString("releaseDate"),
                    jsonObject.getString("primaryGenreName"), jsonObject.getString("trackId"),
                    jsonObject.getString("artistId"),
                    jsonObject.getString("artistName"), jsonObject.getString("genres"), jsonObject.getString("price")
                    , jsonObject.getString("description"), jsonObject.getString("bundleId"),
                    jsonObject.getString("genreIds"), jsonObject.getString("currentVersionReleaseDate"),
                    jsonObject.getString("averageUserRating"), jsonObject.getString("userRatingCount"),
                    addTime, position);
        }
        return num;
    }


}
