package dziedzic.rafal.webQuiz.controller;

import dziedzic.rafal.webQuiz.dao.DaoQuestion;
import dziedzic.rafal.webQuiz.dao.DaoUser;
import dziedzic.rafal.webQuiz.dao.EmailServices;
import dziedzic.rafal.webQuiz.model.Question;
import dziedzic.rafal.webQuiz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class StartController {

    @Autowired
    EmailServices emailServices;

    @Autowired
    DaoUser daoUser;
    @Autowired
    DaoQuestion daoQuestion;

    int questionCount = 0;
    int userPoints = 0;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showInputForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "startForm";


    }

    @PostMapping(value = "/")
    public String createUser(@ModelAttribute User user, ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        daoUser.addUser(user);

        System.out.println(user.toString());

        return "redirect:/question";
    }

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String question(ModelMap modelMap) {
        modelMap.addAttribute("question", new Question());
        modelMap.addAttribute("textQuestion", daoQuestion.showAll().get(questionCount).getQuestionText());

        modelMap.addAttribute("answerA", daoQuestion.showAll().get(questionCount).answersA);
        modelMap.addAttribute("answerB", daoQuestion.showAll().get(questionCount).answersB);
        modelMap.addAttribute("answerC", daoQuestion.showAll().get(questionCount).answersC);

        return "question";
    }

    @PostMapping(value = "/question")
    public String getAnswer(@ModelAttribute Question question, ModelMap modelMap) {
        modelMap.addAttribute("question", question);
        String url = "";
        if (daoQuestion.showAll().get(questionCount).getCorrectAnswer() == question.getUserAnswer()) {
            userPoints++;
        }
        questionCount++;

        if (questionCount < 5) {
            url = "question";
        } else {
            url = "thankyou";
        }


        return "redirect:/" + url;
    }


    @RequestMapping(value = "/thankyou")
    public String summary(ModelMap modelMap) {

        String summary = "Uzyskales punktow: " + userPoints + " Gratuluje";

        String thanks = "Dziekujemy za wypelnienie naszego testu " + daoUser.showAll().get(0).getName();

        modelMap.addAttribute("summary", summary);
        modelMap.addAttribute("thanks", thanks);

        emailServices.sendMessage(daoUser.showAll().get(0).getEmail(),"Wynik testu","Dziekuje");

        return "thankYou";
    }

}