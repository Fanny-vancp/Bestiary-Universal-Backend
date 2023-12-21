package be.heh.bestiaryuniversal.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UniverseValidation {
    public String getNameUniverse() {
        return nameUniverse;
    }

    public void setNameUniverse(String nameUniverse) {
        this.nameUniverse = nameUniverse;
    }

    public String getImgUniverse() {
        return imgUniverse;
    }

    public void setImgUniverse(String imgUniverse) {
        this.imgUniverse = imgUniverse;
    }

    private String nameUniverse;
    private String imgUniverse;

    @JsonCreator
    public UniverseValidation(
            @JsonProperty("nameUniverse") String nameUniverse,
            @JsonProperty("imgUniverse") String imgUniverse) {
        this.nameUniverse = nameUniverse;
        this.imgUniverse = imgUniverse;
    }
}
