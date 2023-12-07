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
    public void testFindAllPurchases() {

        persistence = new BeastAdapterPersistence(beastsRepository);
        List<Beast> listBeast = persistence.storeAllBeasts();

        Assertions.assertEquals(1,listBeast.size());
        Assertions.assertEquals("dragon",listBeast.get(0).getNameBeast());
    }
}



