package be.heh.bestiaryuniversal.application.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Beasts {
    private int id;
    private String name;
    public Beasts(int id, String name){
        this.id=id;
        this.name=name;
    }
}
