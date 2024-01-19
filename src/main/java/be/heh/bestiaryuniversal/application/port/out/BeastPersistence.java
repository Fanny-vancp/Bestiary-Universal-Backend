package be.heh.bestiaryuniversal.application.port.out;

import be.heh.bestiaryuniversal.adapter.in.web.BeastValidation;
import be.heh.bestiaryuniversal.application.domain.model.Beast;
import java.util.List;

public interface BeastPersistence {
    List<Beast> storeAllBeasts();
    List<Beast> storeBeastsByUniverse(int idUniverse);
    List<Beast> storeBeastsByUser(int idUser);
    void addNewBeastToDB(BeastValidation newBeast);
    void addBeastToUniverse(int idBeast, int idUniverse);
    void addBeastToUserFavoris(int idBeast, int idUser);
    void deleteBeastFromDB(int idBeast);
    void deleteBeastFromUniverse(int idBeast, int idUniverse);
    void deleteBeastFromUserFavoris(int idBeast, int idUser);
}