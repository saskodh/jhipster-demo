package com.sklechko.jhipster.repository.user;

import com.sklechko.jhipster.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository {

    Optional<User> findOneByActivationKey (String activationKey);

    Optional<User> findOneByResetKey (String resetKey);

    Optional<User> findOneByEmail (String email);

    Optional<User> findOneByLogin (String login);
}
