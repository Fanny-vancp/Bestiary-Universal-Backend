package be.heh.bestiaryuniversal.application.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Beast {
    private int idBeast;
    private String nameBeast;

    public int getIdBeast() {
        return idBeast;
    }

    public void setIdBeast(int idBeast) {
        this.idBeast = idBeast;
    }

    public String getNameBeast() {
        return nameBeast;
    }

    public void setNameBeast(String nameBeast) {
        this.nameBeast = nameBeast;
    }

    public String getImgBeast() {
        return imgBeast;
    }

    public void setImgBeast(String imgBeast) {
        this.imgBeast = imgBeast;
    }

    public String getDescriptionBeast() {
        return descriptionBeast;
    }

    public void setDescriptionBeast(String descriptionBeast) {
        this.descriptionBeast = descriptionBeast;
    }

    private String imgBeast;
    private String descriptionBeast;

    // TO DO
    // add the other attributes for the beast entity

    public Beast(int idBeast, String nameBeast, String descriptionBeast, String imgBeast){
        this.idBeast=idBeast;
        this.nameBeast=nameBeast;
        this.imgBeast=imgBeast;
        this.descriptionBeast=descriptionBeast;
    }
}
