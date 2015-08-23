package com.sklechko.jhipster.repository.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sklechko.jhipster.domain.QUser;
import com.sklechko.jhipster.domain.User;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static java.lang.Boolean.FALSE;

/**
 * Implementation of {@link CustomUserRepository}.
 * */
public class UserRepositoryImpl implements CustomUserRepository {

    private Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    private QUser user = QUser.user;

    @Override
    public List<User> findAllInactiveCreatedBefore (DateTime dateTime) {
        logger.debug("Returning all inactive users created before: '{}'", dateTime);
        return new JPAQueryFactory(entityManager)
            .selectFrom(user)
            .where(user.activated.eq(FALSE)
                .and(user.createdDate.before(dateTime)))
            .fetch();
    }
}
