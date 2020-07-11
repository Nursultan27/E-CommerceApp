package ru.javamentor.ecommerce.webapp.controllers.rest;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.UserDao;
import ru.javamentor.ecommerce.exceptions.EmailAlreadyExistsException;
import ru.javamentor.ecommerce.models.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
    private UserDao userDao;
//    private VerificationTokenDao verificationTokenDao;
    private PasswordEncoder passwordEncoder;

    /*public RegistrationController(UserDao userDao, VerificationTokenDao verificationTokenDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.verificationTokenDao = verificationTokenDao;
        this.passwordEncoder = passwordEncoder;
    }*/

    public RegistrationController(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public void registrationOfNewUser(@RequestBody User newUser, HttpServletRequest httpServletRequest) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        try{
            userDao.persist(newUser);

//            final String token = UUID.randomUUID().toString();
//            final VerificationToken verificationToken = new VerificationToken(token, newUser);
//            verificationTokenDao.persist(verificationToken);

//            final String appUrl = String.format("http://%s:%s%s",
//                                                    httpServletRequest.getServerName(),
//                                                    httpServletRequest.getServerPort(),
//                                                    httpServletRequest.getContextPath());

//            getRegistrationPage(newUser, token, appUrl);

        } catch (EmailAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}
