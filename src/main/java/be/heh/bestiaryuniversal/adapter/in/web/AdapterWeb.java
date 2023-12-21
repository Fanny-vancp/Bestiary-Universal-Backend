package be.heh.bestiaryuniversal.adapter.in.web;

import be.heh.bestiaryuniversal.application.domain.model.Beast;
import be.heh.bestiaryuniversal.application.domain.model.Universe;
import be.heh.bestiaryuniversal.application.port.in.BeastUseCase;
import be.heh.bestiaryuniversal.application.port.in.UniverseUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class AdapterWeb {
    // attribute
    private BeastUseCase beastUseCase;
    private UniverseUseCase universeUseCase;

    //constructor
    public AdapterWeb(BeastUseCase beastUseCase, UniverseUseCase universeUseCase){
        this.beastUseCase=beastUseCase;
        this.universeUseCase = universeUseCase;
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
    @DeleteMapping("/universe")
    public ResponseEntity<String> deleteBeast(@RequestParam(required = true) int idBeast) {
        beastUseCase.deleteBeast(idBeast);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Beast deleted successfully");
    }



    @GetMapping("/universes")
    public ResponseEntity<List<Universe>> universesList(){
        // request
        // https://bestiary.onrender.com/universes -> get all universes

        List<Universe> listUniverse;

        listUniverse = universeUseCase.getAllUniverse();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(listUniverse);
    }

    @PostMapping("/universe")
    public ResponseEntity<String> addUniverse(@RequestBody UniverseValidation universe) {
        universeUseCase.addNewUniverse(universe);
        return ResponseEntity.status(HttpStatus.CREATED).body("Universe added successfully");
    }

    @DeleteMapping("/universe")
    public ResponseEntity<String> deleteUniverse(@RequestParam(required = true) int idUniverse) {
        universeUseCase.deleteUniverse(idUniverse);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Universe deleted successfully");
    }
}
