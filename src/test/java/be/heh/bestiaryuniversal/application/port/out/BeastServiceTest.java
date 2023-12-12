package be.heh.bestiaryuniversal.application.port.out;

import be.heh.bestiaryuniversal.application.domain.model.Beast;
import be.heh.bestiaryuniversal.application.domain.service.BeastService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class BeastServiceTest {

    @Test
    public void test_getAllBeast() {
        BeastPersistence persistenceMock = mock(BeastPersistence.class);


        List<Beast> beastsListVide = new ArrayList<>();
        List<Beast> beastsList = new ArrayList<>();
        beastsList.add(new Beast(1, "Dragon", "R.drawable.dragon", "A mythical fire-breathing creature"));
        beastsList.add(new Beast(2, "Griffin", "R.drawable.griffin", "A majestic creature with the body of a lion and the head of an eagle"));
        beastsList.add(new Beast(3, "Phoenix", "R.drawable.phoenix", "A mythical bird that is cyclically regenerated or reborn"));
        beastsList.add(new Beast(4, "Yeti", "R.drawable.yeti", "A large ape-like creature said to inhabit the Himalayan mountains"));
        beastsList.add(new Beast(5, "Kelpie", "R.drawable.kelpie", "A shape-shifting water spirit inhabiting lochs and pools in Scotland"));

        when(persistenceMock.storeAllBeasts()).thenReturn(beastsList);

        BeastService beastService = new BeastService(persistenceMock);
        List<Beast> beasts=beastService.getAllBeast();

        Assertions.assertEquals(beastsList.size(),beasts.size());
        Assertions.assertEquals(beastsList.get(1).getNameBeast(),beasts.get(1).getNameBeast());

    }

    @Test
    public void test_getBeastByUniverse() {
        BeastPersistence persistenceMock = mock(BeastPersistence.class);


        List<Beast> beastsListVide = new ArrayList<>();
        List<Beast> beastsList = new ArrayList<>();
        beastsList.add(new Beast(1, "Dragon", "dnd", "A mythical fire-breathing creature"));
        beastsList.add(new Beast(2, "Griffin", "dnd", "A majestic creature with the body of a lion and the head of an eagle"));
        beastsList.add(new Beast(3, "Phoenix", "the witcher", "A mythical bird that is cyclically regenerated or reborn"));
        beastsList.add(new Beast(4, "Yeti", "the lord of the ring", "A large ape-like creature said to inhabit the Himalayan mountains"));
        beastsList.add(new Beast(5, "Kelpie", "dnd", "A shape-shifting water spirit inhabiting lochs and pools in Scotland"));

        when(persistenceMock.storeBeastsByUniverse(1)).thenReturn(beastsList);

        BeastService beastService = new BeastService(persistenceMock);
        List<Beast> beasts=beastService.getBeastByUniverse(1);

        Assertions.assertEquals(beastsList.size(),beasts.size());
        Assertions.assertEquals(beastsList.get(1).getNameBeast(),beasts.get(1).getNameBeast());

    }
}