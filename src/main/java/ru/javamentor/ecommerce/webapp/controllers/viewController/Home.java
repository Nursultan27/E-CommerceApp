package ru.javamentor.ecommerce.webapp.controllers.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }

}
