package com.example.modulo8;

import android.util.Log;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    public static void sendEmail(String toEmail, String subject, String body) {
        final String username = "your-email@gmail.com";
        final String password = "lkj42 rmyr bmmx ubqm";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
        } catch (MessagingException e) {
            Log.e("Email","Error enviando email",e);
        }
    }
}

