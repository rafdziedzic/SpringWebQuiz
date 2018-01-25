package dziedzic.rafal.webQuiz.services;

import dziedzic.rafal.webQuiz.dao.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServicesImpl implements EmailServices {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendMessage(String to, String subject, String text) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);

    }

}
