package harlina.mail;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

class Configuration
{
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    JavaMailSenderImpl javaMailSender()
    {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setJavaMailProperties(properties);
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);

        javaMailSender.setUsername(USERNAME);
        javaMailSender.setPassword(PASSWORD);

        return javaMailSender;
    }
}
