package ru.javamentor.ecommerce.service;

import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.javamentor.ecommerce.events.UserRegistrationEvent;
import ru.javamentor.ecommerce.service.abstracts.modelService.VerificationTokenService;

@Service
public class EmailVerificationListener implements ApplicationListener<UserRegistrationEvent> {

    private final JavaMailSender javaMailSender;
    private VerificationTokenService verificationTokenService;

    public EmailVerificationListener(JavaMailSender javaMailSender, VerificationTokenService verificationTokenService) {
        this.javaMailSender = javaMailSender;
        this.verificationTokenService = verificationTokenService;
    }

    @Override
    public void onApplicationEvent(UserRegistrationEvent userRegistrationEvent) {
        String username = userRegistrationEvent.getUser().getUsername();

        Long verificationTokenId = verificationTokenService.createVerification(username);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Internet shop email verification");
        message.setText("Account verification link: http://localhost:8080/verify/email?id=" + verificationTokenId);
        message.setTo(username);

        javaMailSender.send(message);
    }
}
