package be.heh.bestiaryuniversal.application.port.out;

import be.heh.bestiaryuniversal.BestiaryUniversalApplication;
import be.heh.bestiaryuniversal.adapter.out.persistance.BeastAdapterPersistence;
import be.heh.bestiaryuniversal.adapter.out.persistance.repository.BeastsRepository;
import be.heh.bestiaryuniversal.application.domain.model.Beast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest(classes = BestiaryUniversalApplication.class)
public class BeastAdapterPersistenceTest {
    @Autowired
    private BeastsRepository beastsRepository;
    private BeastAdapterPersistence persistence ;

    @Test
    public void testFindAllBeasts() {

        persistence = new BeastAdapterPersistence(beastsRepository);
        List<Beast> listBeast = persistence.storeAllBeasts();

        Assertions.assertEquals(4,listBeast.size());
        Assertions.assertEquals("dragon",listBeast.get(0).getNameBeast());
    }

    @Test
    public void testFindBeastsByUniverse(){
        persistence = new BeastAdapterPersistence(beastsRepository);
        List<Beast> listBeast = persistence.storeBeastsByUniverse(1);

        Assertions.assertEquals(2,listBeast.size());
    }

    @Test
    public void testAddNewBeastToDB(){
        persistence = new BeastAdapterPersistence(beastsRepository);
        Beast beast = new Beast(5, "guenaude","url img","description");
        //persistence.addNewBeastToDB(beast);

        //List<Beast> listBeast = persistence.storeAllBeasts();

        //Assertions.assertEquals(6,listBeast.size());
    }
}



