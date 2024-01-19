package be.heh.bestiaryuniversal.application.port.out;

import be.heh.bestiaryuniversal.application.domain.model.Beast;
import be.heh.bestiaryuniversal.application.domain.model.User;
import be.heh.bestiaryuniversal.application.domain.service.BeastService;
import be.heh.bestiaryuniversal.application.domain.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Test
    public void test_getAllUser() {
        UserPersistence persistenceMock = mock(UserPersistence.class);


        List<User> usersList = new ArrayList<>();
        usersList.add(new User(1, "firstName", "lastName", "login", "email", "pwd"));
        usersList.add(new User(2, "firstName", "lastName", "login", "email", "pwd"));
        usersList.add(new User(3, "firstName", "lastName", "login", "email", "pwd"));
        usersList.add(new User(4, "firstName", "lastName", "login", "email", "pwd"));
        usersList.add(new User(5, "firstName", "lastName", "login", "email", "pwd"));

        when(persistenceMock.storeAllUser()).thenReturn(usersList);

        UserService userService = new UserService(persistenceMock);
        List<User> users=userService.getAllUser();

        Assertions.assertEquals(usersList.size(),users.size());

    }
}
