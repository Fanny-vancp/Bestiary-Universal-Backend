package be.heh.bestiaryuniversal.application.domain.service;

import be.heh.bestiaryuniversal.adapter.in.web.UserValidation;
import be.heh.bestiaryuniversal.application.domain.model.Beast;
import be.heh.bestiaryuniversal.application.domain.model.User;
import be.heh.bestiaryuniversal.application.port.in.UserUseCase;

import java.util.List;

public class UserService implements UserUseCase {

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public List<Beast> getBeastFavByUser() {
        return null;
    }

    @Override
    public void addNewUser(UserValidation newUser) {

    }

    @Override
    public void deleteUser(int idUser) {

    }
}
