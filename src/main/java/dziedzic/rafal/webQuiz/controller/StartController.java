package dziedzic.rafal.webQuiz.controller;

import dziedzic.rafal.webQuiz.dao.DaoUser;
import dziedzic.rafal.webQuiz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class StartController {

    @Autowired
    DaoUser daoUser;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showInputForm(ModelMap modelMap){
       modelMap.addAttribute("user",new User());
        return "startForm";


    }

    @PostMapping(value = "/")
    public String createUser(@ModelAttribute User user, ModelMap modelMap)  {
        modelMap.addAttribute("user",user);
        daoUser.addUser(user);

        System.out.println(user.toString());

        return "redirect:/";
    }


}
