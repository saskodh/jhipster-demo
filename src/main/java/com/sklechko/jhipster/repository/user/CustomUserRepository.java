package com.sklechko.jhipster.repository.user;

import com.sklechko.jhipster.domain.User;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Custom user repository.
 * */
public interface CustomUserRepository {

    List<User> findAllInactiveCreatedBefore (DateTime dateTime);
}
