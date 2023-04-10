package top.luobogan.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.luobogan.service.NotifyService;
import top.luobogan.util.CommonUtil;

import java.util.concurrent.TimeUnit;

/**
 * Created by LuoboGan
 * Date:2023-04-10
 */
@Service
@Slf4j
public class NotifyServiceImpl implements NotifyService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @Async("threadPoolTaskExecutor")
    public void testSend() {

        try {
            long beginTime = CommonUtil.getCurrentTimestamp();
            TimeUnit.MILLISECONDS.sleep(2000);
            long endTime = CommonUtil.getCurrentTimestamp();
            log.info("耗时={}",endTime-beginTime);
        } catch (InterruptedException e) {
            log.info("InterruptedException={}",e);
        }
//        long beginTime = CommonUtil.getCurrentTimestamp();
//        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://www.baidu.net", String.class);
//        String body = forEntity.getBody();
//        long endTime = CommonUtil.getCurrentTimestamp();
//        log.info("耗时={},body={}",endTime-beginTime,body);
    }

}
