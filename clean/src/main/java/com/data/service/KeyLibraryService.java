package com.data.service;

import com.data.mapper.KeyLibraryMapper;
import com.data.mapper.KeyWordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : ganjiaxin
 * create at:  2018/12/21  2:36 PM
 * @description:
 */
@Service
public class KeyLibraryService {

    @Autowired
    KeyLibraryMapper keyLibraryMapper;


    /**
     * 查询关键词主键
     *
     * @param keyName
     * @return
     */
    public Integer selectKeyLibrary(String keyName) {
        Integer id = keyLibraryMapper.selectKeyLibrary(keyName);
        return id;
    }

    /**
     * 更新关键词库
     *
     * @param keyName
     * @return
     */
    public Integer insertKeyLibrary(String keyName) {
        Integer id = keyLibraryMapper.insertKeyLibrary(keyName);
        return id;
    }
}
