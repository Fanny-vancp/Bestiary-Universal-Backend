package be.heh.bestiaryuniversal.application.port.out;

import be.heh.bestiaryuniversal.application.domain.model.Beast;
import java.util.List;

public interface BeastPersistence {
    List<Beast> storeAllBeasts();
    List<Beast> storeBeastsByUniverse();
}