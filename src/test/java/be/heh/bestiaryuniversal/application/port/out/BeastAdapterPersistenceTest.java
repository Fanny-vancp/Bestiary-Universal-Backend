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
    public void testAddBeastToUniverse(){
        persistence = new BeastAdapterPersistence(beastsRepository);
        persistence.addBeastToUniverse(1,2);

        List<Beast> list = persistence.storeBeastsByUniverse(2);
        Assertions.assertEquals(3,list.size());
    }

    @Test
    public void testAddBeastToUserFavoris(){
        persistence = new BeastAdapterPersistence(beastsRepository);
        persistence.addBeastToUserFavoris(6,3);

        List<Beast> list = persistence.storeBeastsByUser(3);
        Assertions.assertEquals(3,list.size());
    }

    @Test
    public void testDeleteBeastFromDB(){
        persistence = new BeastAdapterPersistence(beastsRepository);
        int idBeast = 9;
        persistence.deleteBeastFromDB(idBeast);

        List<Beast> listBeast = persistence.storeAllBeasts();
        Assertions.assertEquals(8, listBeast.size());
    }

    @Test
    public void testDeleteBeastFromUniverse(){
        persistence = new BeastAdapterPersistence(beastsRepository);
        persistence.deleteBeastFromUniverse(1,2);

        List<Beast> list = persistence.storeBeastsByUniverse(2);
        Assertions.assertEquals(2,list.size());
    }

    @Test
    public void testDeleteBeastFromUserFavoris(){
        persistence = new BeastAdapterPersistence(beastsRepository);
        persistence.deleteBeastFromUserFavoris(6,3);

        List<Beast> list = persistence.storeBeastsByUser(3);
        Assertions.assertEquals(2,list.size());
    }
}



