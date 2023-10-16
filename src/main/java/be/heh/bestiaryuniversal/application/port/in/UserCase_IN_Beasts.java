package be.heh.bestiaryuniversal.application.port.in;


import be.heh.bestiaryuniversal.application.domain.model.Beasts;

public interface UserCase_IN_Beasts {
    public void add(Beasts beasts);
    public void get(Beasts beasts);
}
