package be.heh.bestiaryuniversal.application.domain.model;

public class User {
    private int idUser;
    private String firstNameUser;
    private String lastNameUser;
    private String loginUser;
    private String emailUser;
    private String passwordUser;

    public User(int idUser, String firstNameUser, String lastNameUser, String loginUser,
                String emailUser, String passwordUser){
        this.idUser=idUser;
        this.firstNameUser=firstNameUser;
        this.lastNameUser=lastNameUser;
        this.loginUser=loginUser;
        this.emailUser=emailUser;
        this.passwordUser=passwordUser;
    }
}
