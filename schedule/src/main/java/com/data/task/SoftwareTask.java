package com.data.task;

import com.data.utils.DateUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author : ganjiaxin
 * create at:  2018/12/20  9:25 PM
 * @description: 应用信息采集
 */
@Component
public class SoftwareTask {

    /**
     * 每隔5秒执行, 单位：ms。
     */
    @Scheduled(fixedRate = 1000*60)
    public void testFixRate() {
        System.out.println("我每隔1分钟冒泡一次：" + DateUtils.formatDateTime(DateUtils.getNow()));
    }

    @Scheduled(cron = "0 0 1 * * ?")    //每天凌晨1点执行
    public void testMyBatis() {
        System.out.println("我每天凌晨1点开始执行");
        try {
            //定时任务可以做耗时操作，包括做生成数据库报表、文件IO等等需要定时执行的逻辑
            if (null != null) {
                System.out.println("假装在处理定时任务，例如复杂耗时的SQL操作、文件IO什么的");
            } else {
                System.out.println("我什么事都不用做，等待下次再说吧");
            }
        } catch (Exception ex) {

        } finally {

        }

    }

}
