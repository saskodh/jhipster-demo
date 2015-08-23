package com.sklechko.jhipster.service;

import com.sklechko.jhipster.domain.User;
import com.sklechko.jhipster.repository.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * BDD unit test for {@link UserService} with mockito.
 * */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceUnitTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldActivateRegistration() {
        // given
        String givenKey = "givenKey";
        User givenUser = new User();
        givenUser.setActivated(false);
        givenUser.setActivationKey(givenKey);
        given(userRepository.findOneByActivationKey(anyString())).willReturn(Optional.of(givenUser));

        // when
        userService.activateRegistration(givenKey);

        // then
        verify(userRepository).findOneByActivationKey(givenKey);
        assertThat(givenUser.getActivated(), equalTo(true));
        assertThat(givenUser.getActivationKey(), equalTo(null));
        verify(userRepository).save(givenUser);
    }
}
