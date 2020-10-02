package mycompany.sebastian.portfolioBackend.Controller;

import mycompany.sebastian.portfolioBackend.Model.Mail;
import mycompany.sebastian.portfolioBackend.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import java.io.IOException;

@Controller
public class MailController {
    MailService mailService;

    @Autowired
    public MailController(MailService mailService){
        this.mailService = mailService;
    }

    @PostMapping("/mail")
    public String sendMail(Mail mail) throws IOException, MessagingException {
        mailService.sendMail(mail);
        return "redirect:/";
    }

//    @GetMapping("/mail")
//    public void sendMai(Mail mail){
//        mailService.sendMail(mail);
//    }
}
