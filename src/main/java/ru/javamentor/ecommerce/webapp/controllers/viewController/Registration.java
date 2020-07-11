/*
package ru.javamentor.ecommerce.webapp.controllers.viewController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.UserDao;
import ru.javamentor.ecommerce.models.entities.User;

@Controller
public class Registration {
//    private VerificationTokenDao verificationTokenDao;
    private UserDao userDao;


    */
/*@Autowired
    public Registration(VerificationTokenDao verificationTokenDao, UserDao userDao) {
        this.verificationTokenDao = verificationTokenDao;
        this.userDao = userDao;
    }*//*


    public Registration(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registrationConfrirm")
    public String getRegistrationPage(@RequestParam("token") String token,
                                      RedirectAttributes redirectAttributes) {

//        final VerificationToken verificationToken = verificationTokenDao.findByToken(token);
//        final User newUser = verificationToken.getUser();
        newUser.setEnabled(true);
        userDao.persist(newUser);
        redirectAttributes.addFlashAttribute("message", "Your account verified successfully");

        return "redirect::/login";
    }

    public void sendVerificationEmail(User newUser, String token, String appUrl) {

    }
}
*/
