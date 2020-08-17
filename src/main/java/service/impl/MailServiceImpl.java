package service.impl;

import model.Code;
import service.MailService;
import utils.RandomHelper;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.Authenticator;
import java.util.Properties;

public class MailServiceImpl implements MailService {
    @Override
    public void sendConfirmCode() {
        final String username = "tessstttt1@yahoo.com";
        final String password = "Pysya1995h88";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.mail.yahoo.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("ivan.moshchenko3334@gmail.com")
            );
            message.setSubject("Одноразовый код для подтверждения покупки");
            message.setText(RandomHelper.get4DigitCode());

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

