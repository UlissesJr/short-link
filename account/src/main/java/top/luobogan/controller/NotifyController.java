package top.luobogan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.luobogan.service.NotifyService;
import top.luobogan.util.CommonUtil;
import top.luobogan.util.JsonData;

import java.util.concurrent.TimeUnit;

/**
 * Created by LuoboGan
 * Date:2023-04-10
 */
@RestController
@RequestMapping("/api/account/v1")
@Slf4j
public class NotifyController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotifyService notifyService;

    /**
     * 测试发送验证码接口-主要是用于对比优化前后区别
     * @return
     */
    @RequestMapping("send_code")
    public JsonData sendCode(){
        notifyService.testSend();
        return JsonData.buildSuccess();
    }

    @Async
    public void testSend() {
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long beginTime = CommonUtil.getCurrentTimestamp();
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://old.xdclass.net", String.class);
        String body = forEntity.getBody();
        long endTime = CommonUtil.getCurrentTimestamp();
        log.info("耗时={},body={}",endTime-beginTime,body);
    }

}
