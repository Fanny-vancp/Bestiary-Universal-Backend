package be.heh.bestiaryuniversal.application.port.in;


import be.heh.bestiaryuniversal.adapter.in.web.BeastValidation;
import be.heh.bestiaryuniversal.application.domain.model.Beast;

import java.util.List;

public interface BeastUseCase {
    // methods
    List<Beast> getAllBeast();
    List<Beast> getBeastByUniverse(int idUniverse);
    List<Beast> getBeastByUser(int idUser);
    void addNewBeast(BeastValidation newBeast);
    void addBeastInUniverse(int idBeast, int idUniverse);
    void addBeastInUserFavoris(int idBeast, int idUser);
    void deleteBeast(int idBeast);
    void deleteBeastInUniverse(int idBeast, int idUniverse);
    void deleteBeastInUserFavoris(int idBeast, int idUser);
}
