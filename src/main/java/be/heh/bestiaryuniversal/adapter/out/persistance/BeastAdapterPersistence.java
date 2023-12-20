package be.heh.bestiaryuniversal.adapter.out.persistance;

import be.heh.bestiaryuniversal.BestiaryUniversalApplication;
import be.heh.bestiaryuniversal.adapter.in.web.BeastValidation;
import be.heh.bestiaryuniversal.adapter.out.persistance.repository.BeastsRepository;
import be.heh.bestiaryuniversal.application.domain.model.Beast;
import be.heh.bestiaryuniversal.application.port.out.BeastPersistence;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BeastAdapterPersistence implements BeastPersistence {

    // attributes
    private BeastsRepository beastsRepository;

    // constructor
    public  BeastAdapterPersistence(BeastsRepository beastsRepository){
        this.beastsRepository = beastsRepository;
    }

    // methods
    @Override
    public List<Beast> storeAllBeasts() {
        List<Beast> beastsListAnswered = beastsRepository.selectAllBeasts();
        return beastsListAnswered;
    }

    @Override
    public List<Beast> storeBeastsByUniverse(int idUniverse) {
        List<Beast> beastsListAnswered = beastsRepository.selectBeastsByUniverse(idUniverse);
        return beastsListAnswered;
    }

    @Override
    public void addNewBeastToDB(BeastValidation newBeast) {
        beastsRepository.insertNewBeast(newBeast);
    }
}
