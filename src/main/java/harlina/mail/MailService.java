package harlina.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Slf4j
public class MailService
{
    private static final String EMAIL_FROM = "";

    public void send(String text, String receiver)
    {
        Configuration configuration = new Configuration();
        JavaMailSenderImpl javaMailSender = configuration.javaMailSender();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(EMAIL_FROM);
            mimeMessageHelper.setTo(receiver);
            mimeMessageHelper.setSubject("Gitlab users");
            mimeMessageHelper.setText(text, true);

            javaMailSender.send(mimeMessage);
        }
        catch (MessagingException ex) {
            log.error("Error something wrong during sending email");
            log.info(ex.getMessage());
        }
    }
}
