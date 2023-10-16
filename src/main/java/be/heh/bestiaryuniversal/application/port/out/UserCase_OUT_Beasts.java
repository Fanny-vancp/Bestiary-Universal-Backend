package be.heh.bestiaryuniversal.application.port.out;

import be.heh.bestiaryuniversal.application.domain.model.Beasts;

public interface UserCase_OUT_Beasts {
    public boolean verifyBeasts(int id);
    public void addBeasts(Beasts beasts);
}
