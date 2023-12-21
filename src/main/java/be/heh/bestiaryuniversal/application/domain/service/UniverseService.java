package be.heh.bestiaryuniversal.application.domain.service;

import be.heh.bestiaryuniversal.adapter.in.web.UniverseValidation;
import be.heh.bestiaryuniversal.application.domain.model.Universe;
import be.heh.bestiaryuniversal.application.port.in.UniverseUseCase;
import be.heh.bestiaryuniversal.application.port.out.BeastPersistence;
import be.heh.bestiaryuniversal.application.port.out.UniversePersistence;

import java.util.List;

public class UniverseService implements UniverseUseCase {
    UniversePersistence universePersistence;
    public UniverseService(UniversePersistence universePersistence){
        this.universePersistence = universePersistence;
}
    @Override
    public List<Universe> getAllUniverse() {
        List<Universe> universeList = universePersistence.storeAllUniverses();
        return universeList;
    }

    @Override
    public void addNewUniverse(UniverseValidation newUniverse) {
        universePersistence.addNewUniverseToDB(newUniverse);
    }

    @Override
    public void deleteUniverse(int idUniverse) {
        universePersistence.deleteUniverseFromDB(idUniverse);
    }
}
