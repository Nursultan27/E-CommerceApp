package ru.javamentor.ecommerce.webapp.controllers.viewController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.UserDao;

@Controller
public class Registration {
    private UserDao userDao;

@Autowired
    public Registration(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }
}