package be.heh.bestiaryuniversal.adapter.in.web;

import be.heh.bestiaryuniversal.application.domain.model.Beast;
import be.heh.bestiaryuniversal.application.port.in.BeastUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
public class AdapterWeb {
    // attribute
    private BeastUseCase beastUseCase;

    //constructor
    public AdapterWeb(BeastUseCase beastUseCase){
        this.beastUseCase=beastUseCase;
    }
    @GetMapping("/beasts")
    public ResponseEntity<List<Beast>> beastsList(@RequestParam(required = false, defaultValue = "0") int universe){
        // request
        // https://bestiary.onrender.com/beasts -> get all beasts
        // https://bestiary.onrender.com/beasts?universe=1 -> get all beasts by his universe with the id(1)

        List<Beast> listBeast;
        if (universe!=0) {
            listBeast = beastUseCase.getBeastByUniverse(universe);
        }else {
            listBeast = beastUseCase.getAllBeast();
        }
        //return listBeast;
        // question for the teacher -> ask if the headers are obligated
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(listBeast);
    }

    @PostMapping("/beast")
    public ResponseEntity<String> addBeast(@RequestBody BeastValidation beast) {
        /*if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed Beast added");
        }*/
        beastUseCase.addNewBeast(beast);
        return ResponseEntity.status(HttpStatus.CREATED).body("Beast added successfully");
    }
    // think about delete
}
