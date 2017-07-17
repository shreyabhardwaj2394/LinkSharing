package com.service;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
/**
 * Created by Shreya on 7/17/2017.
 */
public class MailSendingService {
    private MailSender mailSender;
    private SimpleMailMessage simpleMailMessage;

    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String to, String subject, String msg) {

        /*SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);

        message.setText(String.format(
                simpleMailMessage.getText(), dear, content));

        mailSender.send(message);*/

        SimpleMailMessage message = new SimpleMailMessage();
        String from="shreya2394bhardwaj@gmail.com";
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        mailSender.send(message);

    }
}
