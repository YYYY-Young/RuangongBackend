package com.diamond.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    Map<String,Integer> permitcodes =new HashMap<>();
    private void createcode(String mailMessage) {
        permitcodes.put(mailMessage,((int) ((Math.random() * 9 + 1) * 100000)));
    }
    public void sendMsg(String toemailAddress) {
        Random rm = new Random();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        // 邮件发送者，这里不能随便填写，必须是真实的发送邮件的邮箱名称
        mailMessage.setFrom("570723764@qq.com");
        // 邮件接受者
        mailMessage.setTo(toemailAddress);
        // 邮件主题
        mailMessage.setSubject("RegisterSubject");
        createcode(toemailAddress);
        // 邮件内容
        String msg=permitcodes.get(toemailAddress).toString();
        mailMessage.setText(msg);
        // 发送邮件
        mailSender.send(mailMessage);
    }
    public String getPermitcodes(String toemailAddress){
            String re= permitcodes.get(toemailAddress).toString();
            permitcodes.remove(toemailAddress);
            return re;
        }

}

