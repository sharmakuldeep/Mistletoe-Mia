package com.sharma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.MailSender;

@Service("emailService")
public class EmailService {
 
    @Autowired
    private MailSender mailSender;
     
    public void sendEmail(String to, String from, String sub, String msgBody){
         
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(sub);
        message.setText(msgBody);
        mailSender.send(message);
    }    
}