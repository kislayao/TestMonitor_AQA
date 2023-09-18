package models;

import com.github.javafaker.Faker;
import helper.FakerHelper;
import lombok.Data;

@Data
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

}
