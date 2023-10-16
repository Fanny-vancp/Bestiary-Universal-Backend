package be.heh.bestiaryuniversal;

import be.heh.bestiaryuniversal.application.domain.model.Beasts;
import be.heh.bestiaryuniversal.application.domain.service.GestionBeasts;
import org.junit.jupiter.api.Test;
import be.heh.bestiaryuniversal.application.port.out.UserCase_OUT_Beasts;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class addBeastsIfNotExists {
    private static final Beasts BEASTS=new Beasts(1,"Leviathan");
    private static final boolean CONDITION = false;
    @Test
    public void shouldAddBeasts(){
        UserCase_OUT_Beasts beastsOut = mock(UserCase_OUT_Beasts.class);
        GestionBeasts gestionBeasts =new GestionBeasts(beastsOut);
        when(beastsOut.verifyBeasts(BEASTS.getId())).thenReturn(CONDITION);
        gestionBeasts.add(BEASTS);
        verify(beastsOut).addBeasts(BEASTS);
    }

}

