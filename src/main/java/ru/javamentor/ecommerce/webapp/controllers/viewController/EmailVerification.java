package ru.javamentor.ecommerce.webapp.controllers.viewController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.UserDao;
import ru.javamentor.ecommerce.models.entities.User;
import ru.javamentor.ecommerce.service.abstracts.modelService.VerificationTokenService;

@Controller
public class EmailVerification {
    private VerificationTokenService verificationTokenService;
    private UserDao userDao;

    @Autowired
    public EmailVerification(VerificationTokenService verificationTokenService, UserDao userDao) {
        this.verificationTokenService = verificationTokenService;
        this.userDao = userDao;
    }

    @GetMapping("/verify/email")
    public String getEmailVerificationPage(@RequestParam("id") Long id) {
        String username = verificationTokenService.getUsernameForId(id);

        userDao.findUserByEmail(username).setEnabled(true);
        userDao.update(userDao.findUserByEmail(username));

        return "login";
    }
}
