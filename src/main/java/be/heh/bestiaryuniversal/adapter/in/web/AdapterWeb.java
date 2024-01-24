package be.heh.bestiaryuniversal.adapter.in.web;

import be.heh.bestiaryuniversal.application.domain.model.Beast;
import be.heh.bestiaryuniversal.application.domain.model.Universe;
import be.heh.bestiaryuniversal.application.domain.model.User;
import be.heh.bestiaryuniversal.application.port.in.BeastUseCase;
import be.heh.bestiaryuniversal.application.port.in.UniverseUseCase;
import be.heh.bestiaryuniversal.application.port.in.UserUseCase;
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
    private UserUseCase userUseCase;

    //constructor
    public AdapterWeb(BeastUseCase beastUseCase, UniverseUseCase universeUseCase, UserUseCase userUseCase){
        this.beastUseCase=beastUseCase;
        this.universeUseCase = universeUseCase;
        this.userUseCase= userUseCase;
    }



    // beast
    @GetMapping("/beasts")
    public ResponseEntity<List<Beast>> beastsList(
            @RequestParam(required = false, defaultValue = "0") int universe,
            @RequestParam(required = false, defaultValue = "0") int user){
        // request
        // https://bestiary.onrender.com/beasts -> get all beasts
        // https://bestiary.onrender.com/beasts?universe=1 -> get all beasts by his universe with the id(1)
        // https://bestiary.onrender.com/beasts?user=1 -> get all favorites beasts by the id of the current user(1)

        List<Beast> listBeast;
        if (universe!=0) {
            listBeast = beastUseCase.getBeastByUniverse(universe);
        }else if (user!=0){
            listBeast = beastUseCase.getBeastByUser(user);
        }else {
            listBeast = beastUseCase.getAllBeast();
        }
        //return listBeast;
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

    @DeleteMapping("/beast")
    public ResponseEntity<String> deleteBeast(@RequestParam(required = true) int idBeast) {
        beastUseCase.deleteBeast(idBeast);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Beast deleted successfully");
    }


    // favoris
    @PostMapping("/favoris")
    public ResponseEntity<String> addBeastInFavoris(
            @RequestParam(required = true) int beast,
            @RequestParam(required = true) int user){
        beastUseCase.addBeastInUserFavoris(beast, user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Beast added successfully");
    }

    @DeleteMapping("/favoris")
    public ResponseEntity<String> deleteBeastInFavoris(
            @RequestParam(required = true) int beast,
            @RequestParam(required = true) int user){
        beastUseCase.deleteBeastInUserFavoris(beast, user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Beast added successfully");
    }


    // universe
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



    // user
    @GetMapping("/users")
    public ResponseEntity<List<User>> usersList(){
        // request
        // https://bestiary.onrender.com/users -> get all users

        List<User> listUsers;

        listUsers = userUseCase.getAllUser();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(listUsers);
    }

    @PostMapping("/user")
    public ResponseEntity<String> addNewUser(@RequestBody UserValidation user){
        userUseCase.addNewUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
    }

    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(@RequestParam(required = true) int idUser){
        userUseCase.deleteUser(idUser);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("User deleted successfully");
    }


    // /beast=1?user=1 -> add a favoris
}
