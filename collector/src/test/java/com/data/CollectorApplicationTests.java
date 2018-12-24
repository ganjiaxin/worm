package com.data;

import com.data.utils.HttpClientUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectorApplicationTests {

    @Test
    public void contextLoads() {

        String result = HttpClientUtil.doPost("https://itunes.apple.com/search?term=网易&media=software&country=cn" +
                "&limit=25", "", "UTF-8");
        System.out.println(result);
    }

}

