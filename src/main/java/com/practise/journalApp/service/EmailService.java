package com.practise.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String Body) {
        try{
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(Body);
            javaMailSender.send(mail);
        }catch (Exception e){
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}
