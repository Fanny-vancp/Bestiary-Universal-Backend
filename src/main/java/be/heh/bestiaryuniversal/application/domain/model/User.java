package be.heh.bestiaryuniversal.application.domain.model;

public class User {
    public int getIdUser() {
        return idUser;
    }

    public String getFirstNameUser() {
        return firstNameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

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
