package be.heh.bestiaryuniversal.application.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Beast {
    private int idBeast;
    private String nameBeast;
    private String imgBeast;
    private String descriptionBeast;

    // TO DO
    // add the other attributes for the beast entity

    public Beast(int idBeast, String nameBeast, String imgBeast, String descriptionBeast){
        this.idBeast=idBeast;
        this.nameBeast=nameBeast;
        this.imgBeast=imgBeast;
        this.descriptionBeast=descriptionBeast;
    }
}
