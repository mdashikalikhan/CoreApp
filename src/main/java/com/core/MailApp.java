package com.core;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailApp {


    private static final String SERVER_SMTP = "smtp.office365.com";
    private static final int PORT_SERVER_SMTP = 587;
    private static final String STANDARD_ACCOUNT = "cbx.retail@sonaliintellect.com";
    private static final String PASSWORD_STANDARD_ACCOUNT = "sonali@123";

    private final String from = "cbx.retail@sonaliintellect.com";
    private final String to = "ashik.khan@sonaliintellect.com";

    private String[] recepients= new String[]{"ashik.khan@sonaliintellect.com",
    "iftekhar.mahmud@sonaliintellect.com", "enamul.wahab@sonaliintellect.com",
    "sumonbass@gmail.com,khan.ashik@gmail.com"};
    private final String subject = "Teste For Hai hai Mama";
    private final String messageContent = "Teste for Hai hai Chandu Mama........";

    public void sendEmail() {
        final Session session = Session.getInstance(this.getEmailProperties(), new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(STANDARD_ACCOUNT, PASSWORD_STANDARD_ACCOUNT);
            }

        });

        try {
            final Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(messageContent);
            message.setSentDate(new Date());
            Transport.send(message);
        } catch (final MessagingException ex) {
        }
    }

    public Properties getEmailProperties() {
        final Properties config = new Properties();
        config.put("mail.smtp.auth", "true");
        config.put("mail.smtp.starttls.enable", "true");
        config.put("mail.smtp.host", SERVER_SMTP);
        config.put("mail.smtp.port", PORT_SERVER_SMTP);
        return config;
    }

    public static void main(final String[] args) {
        new MailApp().sendEmail();
    }

}
