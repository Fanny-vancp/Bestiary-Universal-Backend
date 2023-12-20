package be.heh.bestiaryuniversal.application.domain.service;


import be.heh.bestiaryuniversal.adapter.in.web.BeastValidation;
import be.heh.bestiaryuniversal.application.domain.model.Beast;
import be.heh.bestiaryuniversal.application.port.in.BeastUseCase;
import be.heh.bestiaryuniversal.application.port.out.BeastPersistence;

import java.util.ArrayList;
import java.util.List;

public class BeastService implements BeastUseCase {
    // attributes
    BeastPersistence beastPersistence;
    public BeastService(BeastPersistence beastPersistence){
        this.beastPersistence=beastPersistence;
    }
    @Override
    public List<Beast> getAllBeast() {
        List<Beast> beastsList = beastPersistence.storeAllBeasts();
        return beastsList;
    }

    @Override
    public List<Beast> getBeastByUniverse(int idUniverse) {
        List<Beast> beastsList = beastPersistence.storeBeastsByUniverse(idUniverse);
        return beastsList;
    }

    @Override
    public void addNewBeast(BeastValidation newBeast) {
        beastPersistence.addNewBeastToDB(newBeast);
    }
}
