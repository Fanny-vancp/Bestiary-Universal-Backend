package be.heh.bestiaryuniversal.application.port.out;

import be.heh.bestiaryuniversal.adapter.in.web.UniverseValidation;
import be.heh.bestiaryuniversal.application.domain.model.Universe;

import java.util.List;

public interface UniversePersistence {
    List<Universe> storeAllUniverses();
    void addNewUniverseToDB(UniverseValidation newUniverse);
    void deleteUniverseFromDB(int idUniverse);
}
