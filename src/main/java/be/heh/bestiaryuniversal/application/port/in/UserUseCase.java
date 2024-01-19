package be.heh.bestiaryuniversal.application.port.in;

import be.heh.bestiaryuniversal.adapter.in.web.UserValidation;
import be.heh.bestiaryuniversal.application.domain.model.User;
import be.heh.bestiaryuniversal.application.domain.model.Beast;

import java.util.List;

public interface UserUseCase {
    List<User> getAllUser();
    User getUserById();
    void addNewUser(UserValidation newUser);
    void deleteUser(int idUser);
}
