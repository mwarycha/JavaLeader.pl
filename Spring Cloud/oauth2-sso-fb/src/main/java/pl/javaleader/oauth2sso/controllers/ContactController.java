package pl.javaleader.oauth2sso.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import pl.javaleader.oauth2sso.model.Contactdata;
import pl.javaleader.oauth2sso.repositories.ContactRepository;
import java.util.List;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @PostMapping("/contact-process")
    public String processForm(@Valid @ModelAttribute Contactdata contactdata, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            System.out.println(errors);
            }
        else {
            saveContact(contactdata);
            model.addAttribute("success_contact_message_added", "wiadomość dostarczona");
        }

        return "index";
    }

    private void saveContact(Contactdata contactdata) {
        contactRepository.save(contactdata);
    }
}
