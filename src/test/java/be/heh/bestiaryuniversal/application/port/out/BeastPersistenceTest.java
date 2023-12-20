package be.heh.bestiaryuniversal.application.port.out;

import be.heh.bestiaryuniversal.BestiaryUniversalApplication;
import be.heh.bestiaryuniversal.adapter.out.persistance.BeastAdapterPersistence;
import be.heh.bestiaryuniversal.adapter.out.persistance.repository.BeastsRepository;
import be.heh.bestiaryuniversal.application.domain.model.Beast;
import be.heh.bestiaryuniversal.application.domain.service.BeastService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = BestiaryUniversalApplication.class)
public class BeastPersistenceTest {

@Autowired
private BeastsRepository beastsRepository;

private BeastAdapterPersistence persistence ;
    @Test
    public void testFindAllBeasts() {
        persistence = new BeastAdapterPersistence(beastsRepository);
        List<Beast> beastsListAnswered = beastsRepository.selectAllBeasts();

        Assertions.assertEquals(4,beastsListAnswered.size());
        Assertions.assertEquals("dragon",beastsListAnswered.get(0).getNameBeast());
    }
}

