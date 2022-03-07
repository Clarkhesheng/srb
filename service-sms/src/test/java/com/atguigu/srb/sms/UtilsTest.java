package com.atguigu.srb.sms;

import com.atguigu.srb.sms.util.SmsProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UtilsTest {
    @Resource
    private RedisTemplate redisTemplate;
    @Test
    public void testProperties(){

        System.out.println(SmsProperties.REGION_Id);
        System.out.println(SmsProperties.KEY_ID);
        System.out.println(SmsProperties.KEY_SECRET);
        System.out.println(SmsProperties.TEMPLATE_CODE);
        System.out.println(SmsProperties.SIGN_NAME);
    }
    @Test
    public void saveRedis(){
        redisTemplate.opsForValue().set("runoob","test",5, TimeUnit.MINUTES);
        String testA = (String) redisTemplate.opsForValue().get("runoob");
        System.out.println(testA);
    }
}
