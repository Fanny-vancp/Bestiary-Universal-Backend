package be.heh.bestiaryuniversal.application.port.out;

import be.heh.bestiaryuniversal.BestiaryUniversalApplication;
import be.heh.bestiaryuniversal.adapter.in.web.BeastValidation;
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
    public void testStoreAllBeasts() {

        persistence = new BeastAdapterPersistence(beastsRepository);
        List<Beast> listBeast = persistence.storeAllBeasts();

        //Assertions.assertEquals(4,listBeast.size());
        Assertions.assertEquals("dragon",listBeast.get(0).getNameBeast());
    }

    @Test
    public void testStoreBeastsByUniverse(){
        persistence = new BeastAdapterPersistence(beastsRepository);
        List<Beast> listBeast = persistence.storeBeastsByUniverse(1);

        Assertions.assertEquals(2,listBeast.size());
    }

    @Test
    public void testStoreBeastsByUser(){
        persistence = new BeastAdapterPersistence(beastsRepository);
        List<Beast> listBeast = persistence.storeBeastsByUser(5);

        Assertions.assertEquals(3,listBeast.size());
    }

    @Test
    public void testAddNewBeastToDB(){
        persistence = new BeastAdapterPersistence(beastsRepository);
        BeastValidation beast = new BeastValidation( "guenaude","url img","description");
        persistence.addNewBeastToDB(beast);

        List<Beast> listBeast = persistence.storeAllBeasts();

        //Assertions.assertEquals(6,listBeast.size());
    }

    @Test
    public void testDeleteBeastFromDB(){
        persistence = new BeastAdapterPersistence(beastsRepository);
        int idBeast = 10;
        persistence.deleteBeastFromDB(idBeast);

        List<Beast> listBeast = persistence.storeAllBeasts();
        Assertions.assertEquals(9, listBeast.size());
    }
}



