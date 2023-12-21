package be.heh.bestiaryuniversal.application.port.out;

import be.heh.bestiaryuniversal.adapter.in.web.BeastValidation;
import be.heh.bestiaryuniversal.application.domain.model.Beast;
import java.util.List;

public interface BeastPersistence {
    List<Beast> storeAllBeasts();
    List<Beast> storeBeastsByUniverse(int idUniverse);
    void addNewBeastToDB(BeastValidation newBeast);
    void deleteBeastFromDB(int idBeast);
}