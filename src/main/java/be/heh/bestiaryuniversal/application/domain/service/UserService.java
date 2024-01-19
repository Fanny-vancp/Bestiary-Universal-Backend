package be.heh.bestiaryuniversal.application.domain.service;

import be.heh.bestiaryuniversal.adapter.in.web.UserValidation;
import be.heh.bestiaryuniversal.application.domain.model.Beast;
import be.heh.bestiaryuniversal.application.domain.model.User;
import be.heh.bestiaryuniversal.application.port.in.UserUseCase;
import be.heh.bestiaryuniversal.application.port.out.UserPersistence;

import java.util.List;

public class UserService implements UserUseCase {

    UserPersistence userPersistence;

    public UserService(UserPersistence userPersistence){
        this.userPersistence=userPersistence;
    }

    @Override
    public List<User> getAllUser() {
        List<User> usersList = userPersistence.storeAllUser();
        return usersList;
    }

    @Override
    public User getUserById() {
        return null;
    }

    @Override
    public void addNewUser(UserValidation newUser) {

    }

    @Override
    public void deleteUser(int idUser) {

    }
}
