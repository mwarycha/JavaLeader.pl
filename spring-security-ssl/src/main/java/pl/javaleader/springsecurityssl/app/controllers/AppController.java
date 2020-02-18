package pl.javaleader.springsecurityssl.app.controllers;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AppController {

  @RequestMapping("/login")
  public String loginPage() {
    return "loginPage";
  }

  @RequestMapping("/login-error")
  public String loginErrorPage(Model model) {
    model.addAttribute("loginError", true);
    return "loginPage";
  }

  @RequestMapping("/success")
  public String loginSuccessPage() {
    return "securityPage";
  }

}