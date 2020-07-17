package ru.javamentor.ecommerce.service.impl.modelImpl;

import org.springframework.stereotype.Service;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.VerificationTokenDao;
import ru.javamentor.ecommerce.models.entities.VerificationToken;
import ru.javamentor.ecommerce.service.abstracts.modelService.VerificationTokenService;

import java.util.Optional;

@Service
public class VerificationTokenServiceImpl extends ReadWriteServiceImpl<VerificationToken, Long> implements VerificationTokenService {
    private VerificationTokenDao verificationTokenDao;

    protected VerificationTokenServiceImpl(VerificationTokenDao verificationTokenDao) {
        super(verificationTokenDao);
        this.verificationTokenDao = verificationTokenDao;
    }

    @Override
    public Long getVerificationTokenIdByUsername(String username) {
        VerificationToken verificationToken = verificationTokenDao.findByUsername(username);
        if(verificationToken != null) {
            return verificationToken.getId();
        }
        return null;
    }

    @Override
    public Long createVerification(String username) {
        if (!verificationTokenDao.existsByUsername(username)) {

            VerificationToken verificationToken = new VerificationToken(username);
            verificationTokenDao.persist(verificationToken);

            return verificationToken.getId();
        }

        return getVerificationTokenIdByUsername(username);
    }

    @Override
    public String getUsernameForId(Long id) {
        Optional<VerificationToken> verification = Optional.ofNullable(verificationTokenDao.getByKey(id));
        if(verification.isPresent()) {
            return verification.get().getUsername();
        }
        return null;
    }
}

