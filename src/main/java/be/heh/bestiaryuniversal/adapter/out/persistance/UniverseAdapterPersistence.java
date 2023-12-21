package be.heh.bestiaryuniversal.adapter.out.persistance;

import be.heh.bestiaryuniversal.adapter.in.web.UniverseValidation;
import be.heh.bestiaryuniversal.adapter.out.persistance.repository.UniverseRepository;
import be.heh.bestiaryuniversal.application.domain.model.Universe;
import be.heh.bestiaryuniversal.application.port.out.UniversePersistence;

import java.util.List;

public class UniverseAdapterPersistence implements UniversePersistence {
    private UniverseRepository universeRepository;

    public UniverseAdapterPersistence(UniverseRepository universesRepository) {
        this.universeRepository = universesRepository;
    }

    @Override
    public List<Universe> storeAllUniverses() {
        List<Universe> universesListAnswered = universeRepository.selectAllUniverses();
        return universesListAnswered;
    }

    @Override
    public void addNewUniverseToDB(UniverseValidation newUniverse) {
        universeRepository.insertNewUniverse(newUniverse);
    }

    @Override
    public void deleteUniverseFromDB(int idUniverse) {
        universeRepository.deleteUniverseFromTheDB(idUniverse);
    }

}