package com.clearlove;

import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootTest
class Springboot08TaskApplicationTests {

  @Autowired
  JavaMailSenderImpl mailSender;

  @Test
  void contextLoads() {

    // 一个简单的邮件
    SimpleMailMessage mailMessage = new SimpleMailMessage();

    mailMessage.setSubject("小狂神你好呀~");
    mailMessage.setText("谢谢你的狂神说Java系列课程~");
    mailMessage.setTo("24736743@qq.com");
    mailMessage.setFrom("24736743@qq.com");
    mailSender.send(mailMessage);

  }


  @Test
  void contextLoads2() throws MessagingException {


    // 一个复杂的邮件
    MimeMessage mimeMessage = mailSender.createMimeMessage();
    // 组装
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");

    helper.setSubject("小狂神你好呀~plus");
    helper.setText("<p style='color:red'>谢谢你的狂神说Java系列课程~</p>",true);

    // 附件
    helper.addAttachment("1.jpg", new File("D:\\1.jpg"));
    helper.addAttachment("2.jpg", new File("D:\\1.jpg"));


    helper.setTo("24736743@qq.com");
    helper.setFrom("24736743@qq.com");

    mailSender.send(mimeMessage);


  }


  /**
   *
   * @param html
   * @param subject
   * @param text
   * @throws MessagingException
   */
  public void sendMail(Boolean html,String subject,String text) throws MessagingException {

    MimeMessage mimeMessage = mailSender.createMimeMessage();

    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);

    helper.setSubject(subject);
    helper.setText(text,true);

    helper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Desktop\\1.jpg"));
    helper.addAttachment("2.jpg",new File("C:\\Users\\Administrator\\Desktop\\1.jpg"));
    helper.setTo("24736743@qq.com");
    helper.setFrom("24736743@qq.com");
    mailSender.send(mimeMessage);
  }

}
