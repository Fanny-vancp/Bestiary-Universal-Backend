package be.heh.bestiaryuniversal;

import be.heh.bestiaryuniversal.adapter.out.persistance.BeastAdapterPersistence;
import be.heh.bestiaryuniversal.adapter.out.persistance.UniverseAdapterPersistence;
import be.heh.bestiaryuniversal.adapter.out.persistance.repository.BeastsRepository;
import be.heh.bestiaryuniversal.adapter.out.persistance.repository.UniverseRepository;
import be.heh.bestiaryuniversal.application.domain.service.BeastService;
import be.heh.bestiaryuniversal.application.domain.service.UniverseService;
import be.heh.bestiaryuniversal.application.port.in.BeastUseCase;
import be.heh.bestiaryuniversal.application.port.in.UniverseUseCase;
import be.heh.bestiaryuniversal.application.port.out.BeastPersistence;
import be.heh.bestiaryuniversal.application.port.out.UniversePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories
public class Config {
   @Autowired
    BeastsRepository beastsRepository;

    BeastPersistence beastPersistence;
    @Autowired
    UniverseRepository universeRepository;
    UniversePersistence universePersistence;

   /* @Bean
    public BeastPersistence getBeastPersistence(){
        beastPersistence=new BeastAdapterPersistence(beastsRepository);
        return beastPersistence;
    }*/
    @Bean
    public BeastUseCase getBeastUseCase(){
        return new BeastService(new BeastAdapterPersistence(beastsRepository));
    }

    @Bean
    public UniverseUseCase getUniverseUseCase() {
        return new UniverseService(new UniverseAdapterPersistence(universeRepository));
    }
}
