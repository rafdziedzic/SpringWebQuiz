package dziedzic.rafal.webQuiz.dao;

import org.springframework.stereotype.Service;

@Service
public interface EmailServices {

    void sendMessage(String to, String subject, String text);
}
