package be.heh.bestiaryuniversal.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserValidation {
    private String firstNameUser;
    private String lastNameUser;
    private String loginUser;
    private String emailUser;
    private String passwordUser;

    @JsonCreator
    public UserValidation(
            @JsonProperty("firstNameUser") String firstNameUser,
            @JsonProperty("lastNameUser") String lastNameUser,
            @JsonProperty("loginUser") String loginUser,
            @JsonProperty("emailUser") String emailUser,
            @JsonProperty("passwordUser") String passwordUser){
        this.firstNameUser = firstNameUser;
        this.lastNameUser = lastNameUser;
        this.loginUser = loginUser;
        this.emailUser=emailUser;
        this.passwordUser=passwordUser;
    }
}
