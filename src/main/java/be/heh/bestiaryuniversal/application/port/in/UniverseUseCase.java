package be.heh.bestiaryuniversal.application.port.in;

import be.heh.bestiaryuniversal.adapter.in.web.UniverseValidation;
import be.heh.bestiaryuniversal.application.domain.model.Universe;

import java.util.List;

public interface UniverseUseCase {
    List<Universe> getAllUniverse();
    void addNewUniverse(UniverseValidation newUniverse);
    void deleteUniverse(int idUniverse);
}
