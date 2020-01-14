package com.wangjiale;

import com.wangjiale.service.ScheduledService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootAsyncApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("王家乐");
        mailMessage.setText("666~");
        mailMessage.setTo("2636614841@qq.com");
        mailMessage.setFrom("2636614841@qq.com");
        javaMailSender.send(mailMessage);
    }
    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setSubject("java邮件练习");
        helper.setText("<p style='color:red'>学无止境</p>",true);

        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\王家乐\\Desktop\\lj.jpg"));

        helper.setTo("2636614841@qq.com");
        helper.setFrom("2636614841@qq.com");

        javaMailSender.send(mimeMessage);
    }
}
