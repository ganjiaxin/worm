package com.data.task;

import com.data.service.CardingSearchSoftwareService;
import com.data.service.SearchSoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

/**
 * @author : ganjiaxin
 * create at:  2018/12/27  5:55 PM
 * @description:任务类 定义异步工作任务
 */
@Service
public class SearchSoftwareTask {

    @Autowired
    SearchSoftwareService searchSoftwareService;
    @Autowired
    CardingSearchSoftwareService cardingSearchSoftwareService;

    /**
     * 核心任务
     */
    @Async
    public void dotask(String term, String jsonArray) {
         //采集数据入库
        searchSoftwareService.insertSearchSoftware(term, jsonArray);
        //采集数据梳理
        cardingSearchSoftwareService.cardingSearchSoftware(term, jsonArray);

        System.out.println("f1 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
