package be.heh.bestiaryuniversal.adapter.in.web;

import be.heh.bestiaryuniversal.application.domain.model.Beast;
import be.heh.bestiaryuniversal.application.port.in.BeastUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdapterWeb {
    // attribute

    private BeastUseCase beastUseCase;

    //constructor
    public AdapterWeb(BeastUseCase beastUseCase){
        this.beastUseCase=beastUseCase;
    }
    @GetMapping("/beasts")
    public List<Beast> beastsList(@RequestParam(required = false, defaultValue = "0") int universe){
        // request
        // https://bestiary.onrender.com/beasts -> get all beasts
        // https://bestiary.onrender.com/beasts?universe=1 -> get all beasts by his universe with the id(1)

        List<Beast> listBeast;
        if (universe!=0) {
            listBeast = beastUseCase.getBeastByUniverse(universe);
        }else {
            listBeast = beastUseCase.getAllBeast();
        }
        return listBeast;
    }
}
