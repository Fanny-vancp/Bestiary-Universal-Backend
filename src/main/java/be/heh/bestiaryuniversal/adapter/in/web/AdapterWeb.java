package be.heh.bestiaryuniversal.adapter.in.web;

import be.heh.bestiaryuniversal.application.domain.model.Beast;
import be.heh.bestiaryuniversal.application.port.in.BeastUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdapterWeb {
    // attribute
    BeastUseCase beastUseCase;
    @GetMapping("/beasts")
    public List<Beast> beastsList(){
        // don't forget to do the if param universe then use getBeastsByUniverse
        List<Beast> listBeast = beastUseCase.getAllBeast();
        return listBeast;
    }
}
