package mycompany.sebastian.portfolioBackend.Service;

import mycompany.sebastian.portfolioBackend.Model.Mail;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class MailService {
    private JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(Mail mail) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo("sebastianklasa1@gmail.com");
        mimeMessageHelper.setSubject(mail.getSubject());
        mimeMessageHelper.setText(mail.getEmail()+"<br/>"+mail.getName()+"<br/>"+mail.getMessage(), true);
        javaMailSender.send(mimeMessage);
    }

}
