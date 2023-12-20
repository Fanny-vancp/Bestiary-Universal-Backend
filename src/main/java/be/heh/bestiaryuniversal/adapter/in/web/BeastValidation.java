package be.heh.bestiaryuniversal.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BeastValidation {


    public String getNameBeast() {
        return nameBeast;
    }

    public void setNameBeast(String nameBeast) {
        this.nameBeast = nameBeast;
    }

    public String getDescriptionBeast() {
        return descriptionBeast;
    }

    public void setDescriptionBeast(String descriptionBeast) {
        this.descriptionBeast = descriptionBeast;
    }

    public String getImgBeast() {
        return imgBeast;
    }

    public void setImgBeast(String imgBeast) {
        this.imgBeast = imgBeast;
    }



    private String nameBeast;
    private String descriptionBeast;
    private String imgBeast;


    @JsonCreator
    public BeastValidation(
            @JsonProperty("nameBeast") String nameBeast,
            @JsonProperty("descriptionBeast") String descriptionBeast,
            @JsonProperty("imgBeast") String imgBeast) {
        this.nameBeast = nameBeast;
        this.descriptionBeast = descriptionBeast;
        this.imgBeast = imgBeast;
    }
}
