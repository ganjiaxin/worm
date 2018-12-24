package com.data.mapper;


import com.data.entity.SearchSoftware;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface SearchSoftwareMapper {

    @Insert("insert into search_software(term," +
            "ipad_screenshot_urls," +
            "artwork_url60," +
            "screenshot_urls," +
            "appletv_screenshot_urls," +
            "artwork_url512,artwork_url100,artist_view_url,supported_devices" +
            ",advisories,is_game_center_enabled,kind,features,average_user_rating_for_current_version" +
            ",track_censored_name,language_codesISO2A,file_size_bytes,content_advisory_rating" +
            ",user_rating_count_for_current_version,track_view_url,track_content_rating,release_notes,track_name" +
            ",formatted_price,primary_genreId,is_vpp_device_based_licensing_enabled,seller_name,currency" +
            ",wrapper_type,version,minimum_os_version,release_date,primary_genre_name,track_id,artist_id" +
            ",artist_name,genres,price,description,bundle_id,genre_ids,current_version_release_date" +
            ",average_user_rating,user_rating_count,add_time,position) " +
            "values(#{term}," +
            "#{ipadScreenshotUrls}," +
            "#{artworkUrl60}," +
            "#{screenshotUrls}," +
            "#{appletvScreenshotUrls}," +
            "#{artworkUrl512},#{artworkUrl100},#{artistViewUrl},#{supportedDevices}," +
            "#{advisories},#{isGameCenterEnabled},#{kind},#{features},#{averageUserRatingForCurrentVersion}," +
            "#{trackCensoredName},#{languageCodesISO2A},#{fileSizeBytes},#{contentAdvisoryRating}," +
            "#{userRatingCountForCurrentVersion},#{trackViewUrl},#{trackContentRating},#{releaseNotes},#{trackName}," +
            "#{formattedPrice},#{primaryGenreId},#{isVppDeviceBasedLicensingEnabled},#{sellerName},#{currency}," +
            "#{wrapperType},#{version},#{minimumOsVersion},#{releaseDate},#{primaryGenreName},#{trackId},#{artistId}," +
            "#{artistName},#{genres},#{price},#{description},#{bundleId},#{genreIds},#{currentVersionReleaseDate}," +
            "#{averageUserRating},#{userRatingCount},#{addTime},#{position})")
    int insertSearchSoftware(@Param(value = "term") String term,
                             @Param(value = "ipadScreenshotUrls") String ipadScreenshotUrls,
                             @Param(value = "artworkUrl60") String artworkUrl60,
                             @Param(value = "screenshotUrls") String screenshotUrls,
                             @Param(value = "appletvScreenshotUrls") String appletvScreenshotUrls,
                             @Param(value = "artworkUrl512") String artworkUrl512,
                             @Param(value = "artworkUrl100") String artworkUrl100, @Param(value = "artistViewUrl") String artistViewUrl,
                             @Param(value = "supportedDevices") String supportedDevices, @Param(value = "advisories") String advisories,
                             @Param(value = "isGameCenterEnabled") String isGameCenterEnabled, @Param(value = "kind") String kind,
                             @Param(value = "features") String features,
                             @Param(value = "averageUserRatingForCurrentVersion") String averageUserRatingForCurrentVersion,
                             @Param(value = "trackCensoredName") String trackCensoredName,
                             @Param(value = "languageCodesISO2A") String languageCodesISO2A, @Param(value = "fileSizeBytes") String fileSizeBytes,
                             @Param(value = "contentAdvisoryRating") String contentAdvisoryRating,
                             @Param(value = "userRatingCountForCurrentVersion") String userRatingCountForCurrentVersion,
                             @Param(value = "trackViewUrl") String trackViewUrl, @Param(value = "trackContentRating") String trackContentRating,
                             @Param(value = "releaseNotes") String releaseNotes, @Param(value = "trackName") String trackName,
                             @Param(value = "formattedPrice") String formattedPrice, @Param(value = "primaryGenreId") String primaryGenreId,
                             @Param(value = "isVppDeviceBasedLicensingEnabled") String isVppDeviceBasedLicensingEnabled,
                             @Param(value = "sellerName") String sellerName, @Param(value = "currency") String currency,
                             @Param(value = "wrapperType") String wrapperType, @Param(value = "version") String version,
                             @Param(value = "minimumOsVersion") String minimumOsVersion, @Param(value="releaseDate") String releaseDate,
                             @Param(value = "primaryGenreName") String primaryGenreName, @Param(value = "trackId") String trackId,
                             @Param(value = "artistId") String artistId,
                             @Param(value = "artistName") String artistName, @Param(value = "genres") String genres, @Param(value =
            "price") String price, @Param(value="description") String description, @Param(value="bundleId") String bundleId,
                             @Param(value = "genreIds") String genreIds, @Param(value = "currentVersionReleaseDate") String currentVersionReleaseDate,
                             @Param(value = "averageUserRating") String averageUserRating, @Param(value = "userRatingCount") String userRatingCount,
                             @Param(value = "addTime") Date addTime, @Param(value="position") Integer position);
}
