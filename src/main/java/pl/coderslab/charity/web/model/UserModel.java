package pl.coderslab.charity.web.model;

import lombok.Data;

@Data
public class UserModel {

    private Long id;

    private String username;

    private String email;

    private String password;

    private String role;
}
