package be.heh.bestiaryuniversal.application.port.out;

import be.heh.bestiaryuniversal.adapter.in.web.UserValidation;
import be.heh.bestiaryuniversal.application.domain.model.User;

import java.util.List;

public interface UserPersistence {
    List<User> storeAllUser();
    void addNewUserToDB(UserValidation newUser);
    void deleteUserFromDB(int idUser);
}
