package com.sklechko.jhipster.repository;

import com.sklechko.jhipster.domain.PersistentToken;
import com.sklechko.jhipster.domain.User;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Spring Data JPA repository for the PersistentToken entity.
 */
public interface PersistentTokenRepository extends JpaRepository<PersistentToken, String> {

    List<PersistentToken> findByUser (User user);

    List<PersistentToken> findByTokenDateBefore (LocalDate localDate);

}
