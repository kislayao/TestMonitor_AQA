package models;

import lombok.*;

@Data
@Builder

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

}
