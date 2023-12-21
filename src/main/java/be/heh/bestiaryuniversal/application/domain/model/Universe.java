package be.heh.bestiaryuniversal.application.domain.model;

public class Universe {
    private int idUniverse;

    public int getIdUniverse() {
        return idUniverse;
    }

    public void setIdUniverse(int idUniverse) {
        this.idUniverse = idUniverse;
    }

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



    public Universe(int idUniverse, String nameUniverse, String imgUniverse) {
        this.idUniverse = idUniverse;
        this.nameUniverse = nameUniverse;
        this.imgUniverse = imgUniverse;
    }
}
