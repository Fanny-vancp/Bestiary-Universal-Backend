package be.heh.bestiaryuniversal.application.domain.service;


import be.heh.bestiaryuniversal.application.domain.model.Beasts;
import be.heh.bestiaryuniversal.application.port.in.UserCase_IN_Beasts;
import be.heh.bestiaryuniversal.application.port.out.UserCase_OUT_Beasts;

public class GestionBeasts implements UserCase_IN_Beasts{
    UserCase_OUT_Beasts beastsOut;
    public GestionBeasts(UserCase_OUT_Beasts beastsOut){
        this.beastsOut=beastsOut;
    }
    @Override
    public void add(Beasts beasts) {
        boolean isBeastsExist=beastsOut.verifyBeasts(beasts.getId());
        if(!isBeastsExist){
            beastsOut.addBeasts(beasts);
        }
    }

    @Override
    public void get(Beasts beasts) {

    }
}
