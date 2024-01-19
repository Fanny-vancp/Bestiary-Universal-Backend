package be.heh.bestiaryuniversal.application.port.out;

import be.heh.bestiaryuniversal.BestiaryUniversalApplication;
import be.heh.bestiaryuniversal.adapter.in.web.BeastValidation;
import be.heh.bestiaryuniversal.adapter.in.web.UserValidation;
import be.heh.bestiaryuniversal.adapter.out.persistance.BeastAdapterPersistence;
import be.heh.bestiaryuniversal.adapter.out.persistance.UserAdapterPersistence;
import be.heh.bestiaryuniversal.adapter.out.persistance.repository.UserRepository;
import be.heh.bestiaryuniversal.application.domain.model.Beast;
import be.heh.bestiaryuniversal.application.domain.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = BestiaryUniversalApplication.class)
public class UserAdapterPersistenceTest {
    @Autowired
    private UserRepository userRepository;
    private UserAdapterPersistence persistence ;

    @Test
    public void testStoreAllUser() {

        persistence = new UserAdapterPersistence(userRepository);
        List<User> listBeast = persistence.storeAllUser();

        Assertions.assertEquals("stanislas",listBeast.get(0).getFirstNameUser());
    }

    @Test
    public void testAddNewUserToDB(){
        persistence = new UserAdapterPersistence(userRepository);
        UserValidation user = new UserValidation( "Rick","Volvic","Ricky3000","rick.volvic@gmail.com","Ricky123*");
        persistence.addNewUserToDB(user);

        List<User> listUser = persistence.storeAllUser();

        Assertions.assertEquals(2,listUser.size());
    }

    @Test
    public void testDeleteUserFromDB(){
        persistence = new UserAdapterPersistence(userRepository);
        int idUser = 4;
        persistence.deleteUserFromDB(idUser);

        List<User> listUser = persistence.storeAllUser();
        Assertions.assertEquals(1, listUser.size());
    }
}
