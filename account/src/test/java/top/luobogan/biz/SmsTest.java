package top.luobogan.biz;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.luobogan.AccountApplication;
import top.luobogan.component.SmsComponent;
import top.luobogan.config.SmsConfig;

/**
 * Created by LuoboGan
 * Date:2023-04-10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class)
@Slf4j
public class SmsTest {

    @Autowired
    private SmsComponent smsComponent;

    @Autowired
    private SmsConfig smsConfig;

    @Test
    public  void testSendSms(){
        smsComponent.send("175XXXXXXXX",smsConfig.getTemplateId(),"666888");
    }

}

