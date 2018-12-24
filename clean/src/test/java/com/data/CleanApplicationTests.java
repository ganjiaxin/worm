package com.data;

import com.data.entity.KeyWord;
import com.data.mapper.KeyWordMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ComponentScan("com.data.*")
@Configuration
@EnableTransactionManagement
@EnableEurekaClient
@EnableFeignClients
@SpringBootTest
public class CleanApplicationTests {
    @Autowired
    KeyWordMapper keyWordMapper;

    @Test
    public void contextLoads() {
    }

    /**
     * 批量增加学生测试
     */
    @Test
    public void batStuAdd() {
        List<KeyWord> keyWords = new ArrayList<KeyWord>();
        for (int i = 0; i < 10; i++) {
            KeyWord keyWord = new KeyWord();
            keyWord.setState(null);
            keyWord.setKeyId(i);
            keyWord.setTrackId(i);
            keyWord.setKeyName("key" + i);
            keyWords.add(keyWord);
        }
        keyWordMapper.batchInsertKeyWord(keyWords);
        // return null;
    }


}

