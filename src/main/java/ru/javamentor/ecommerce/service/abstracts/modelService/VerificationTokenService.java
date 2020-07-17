package ru.javamentor.ecommerce.service.abstracts.modelService;

import ru.javamentor.ecommerce.models.entities.VerificationToken;

public interface VerificationTokenService extends ReadWriteService<VerificationToken, Long>{

    public Long getVerificationTokenIdByUsername(String username);

    public Long createVerification(String username);

    public String getUsernameForId(Long id);
}
