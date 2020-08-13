package com.diamond.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Classname EmailService
 * @Description TODO
 * @Date 2020/8/10 16:00
 * @Created by lrf
 */
@Component
public class EmailService {


    @Autowired
    private JavaMailSender mailSender;
    ArrayList<String> permitcode =new ArrayList<>();
    private void createcode(){
        permitcode.add("100000");
        permitcode.add("200000");
    }
    public void sendMsg() {
        Random rm = new Random();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        // 邮件发送者，这里不能随便填写，必须是真实的发送邮件的邮箱名称
        mailMessage.setFrom("570723764@qq.com");
        // 邮件接受者
        mailMessage.setTo("ganhao2001@126.com");
        // 邮件主题
        mailMessage.setSubject("RegisterSubject");
        // 邮件内容
        Integer i=rm.nextInt(2);
        mailMessage.setText("100000");
        // 发送邮件
        mailSender.send(mailMessage);
    }

}

