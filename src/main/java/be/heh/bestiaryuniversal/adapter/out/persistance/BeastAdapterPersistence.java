package be.heh.bestiaryuniversal.adapter.out.persistance;

import be.heh.bestiaryuniversal.application.domain.model.Beast;
import be.heh.bestiaryuniversal.application.port.out.BeastPersistence;

import java.util.List;

public class BeastAdapterPersistence implements BeastPersistence {
    @Override
    public List<Beast> storeAllBeasts() {
        return null;
    }

    @Override
    public List<Beast> storeBeastsByUniverse() {
        return null;
    }
}
