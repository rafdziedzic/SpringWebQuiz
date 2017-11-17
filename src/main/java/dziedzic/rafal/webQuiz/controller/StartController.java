package dziedzic.rafal.webQuiz.controller;

import dziedzic.rafal.webQuiz.dao.DaoQuestion;
import dziedzic.rafal.webQuiz.dao.DaoUser;
import dziedzic.rafal.webQuiz.model.Question;
import dziedzic.rafal.webQuiz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class StartController {

    @Autowired         //jeżeli ten obiekt będzie potrzebny to Spring go wstrzyknie,
            DaoUser daoUser;
    @Autowired
    DaoQuestion daoQuestion;

    int questionCount = 0;
    int userPoints = 0;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showInputForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "startForm";  // przekazujemy postego usera, który ma nie ustawione parametry, będziemy poberali metodą
        // post wartości uzytkownika a nastepnie zapisać tego użytkownika

    }

    @PostMapping(value = "/")
    public String createUser(@ModelAttribute User user, ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        daoUser.addUser(user);

        System.out.println(user.toString());  // roboczo generownie usera

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

        if (daoQuestion.showAll().get(questionCount).getCorrectAnswer()==question.getUserAnswer()) {
            userPoints++;
        }
        questionCount++;

        System.out.println(userPoints);

        return "redirect:/question";
    }


}
