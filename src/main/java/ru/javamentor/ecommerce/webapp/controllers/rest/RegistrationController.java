package ru.javamentor.ecommerce.webapp.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.UserDao;
import ru.javamentor.ecommerce.events.UserRegistrationEvent;
import ru.javamentor.ecommerce.exceptions.EmailAlreadyExistsException;
import ru.javamentor.ecommerce.models.entities.User;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private UserDao userDao;
    private PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public RegistrationController(UserDao userDao, PasswordEncoder passwordEncoder, ApplicationEventPublisher eventPublisher) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.eventPublisher = eventPublisher;
    }


    @PostMapping
    public void registerNewUser(@RequestBody User newUser, HttpServletRequest httpServletRequest) {
        try {
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            userDao.persist(newUser);

            eventPublisher.publishEvent(new UserRegistrationEvent(newUser));
        } catch (EmailAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}
