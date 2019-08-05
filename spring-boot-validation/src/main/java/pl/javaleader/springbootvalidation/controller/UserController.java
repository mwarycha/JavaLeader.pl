package pl.javaleader.springbootvalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javaleader.springbootvalidation.model.User;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/user")
    public String userView(Model model){
        model.addAttribute("user", new User("name", 0));
        return "userView";
    }

    @PostMapping("/user")
    public String userView(@Valid @ModelAttribute User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            List<ObjectError> errorsList = bindingResult.getAllErrors();
            for(ObjectError error:errorsList) {
                System.out.println(error);
            }

        }
        return "userView";
    }

}
