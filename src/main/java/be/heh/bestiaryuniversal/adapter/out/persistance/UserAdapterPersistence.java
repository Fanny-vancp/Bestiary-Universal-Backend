package be.heh.bestiaryuniversal.adapter.out.persistance;

import be.heh.bestiaryuniversal.adapter.in.web.UserValidation;
import be.heh.bestiaryuniversal.adapter.out.persistance.repository.UserRepository;
import be.heh.bestiaryuniversal.application.domain.model.User;
import be.heh.bestiaryuniversal.application.port.out.UserPersistence;

import java.util.List;

public class UserAdapterPersistence implements UserPersistence {
    private UserRepository userRepository;

    public UserAdapterPersistence(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public List<User> storeAllUser() {
        List<User> userList = userRepository.selectAllUser();
        return userList;
    }

    @Override
    public void addNewUserToDB(UserValidation newUser) {
        userRepository.insertNewUser(newUser);
    }

    @Override
    public void deleteUserFromDB(int idUser) {
        userRepository.deleteUserFromTheDB(idUser);
    }
}
