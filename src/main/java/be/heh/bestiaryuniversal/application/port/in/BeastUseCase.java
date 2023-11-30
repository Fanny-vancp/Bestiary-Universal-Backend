package be.heh.bestiaryuniversal.application.port.in;


import be.heh.bestiaryuniversal.application.domain.model.Beast;

import java.util.List;

public interface BeastUseCase {
    // methods
    List<Beast> getAllBeast();
    List<Beast> getBeastByUniverse(String universe);
}
