package be.heh.bestiaryuniversal.application.port.in;


import be.heh.bestiaryuniversal.adapter.in.web.BeastValidation;
import be.heh.bestiaryuniversal.application.domain.model.Beast;

import java.util.List;

public interface BeastUseCase {
    // methods
    List<Beast> getAllBeast();
    List<Beast> getBeastByUniverse(int idUniverse);
    void addNewBeast(BeastValidation newBeast);
    void deleteBeast(int idBeast);
}
