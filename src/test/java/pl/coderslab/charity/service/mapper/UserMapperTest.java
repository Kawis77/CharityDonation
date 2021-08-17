package pl.coderslab.charity.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.coderslab.charity.dao.entity.UserEntity;
import pl.coderslab.charity.web.model.UserModel;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {
    @Test
    void givenMapperAndModel_whenForm_thenEntityisNotNull() {
        //given
        UserModel userModel = new UserModel();
        UserMapper userMapper = new UserMapper();

        userModel.setId(1L);
        userModel.setUsername("kkk");
        userModel.setEmail("kkk@wp.pl");
        userModel.setPassword("password");
        userModel.setRole("ROLE_USER");

        //when

        UserEntity userEntity = userMapper.form(userModel);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(userEntity.getId(), "Id is null"),
                () -> Assertions.assertNotNull(userEntity.getUsername(), "Username is null"),
                () -> Assertions.assertNotNull(userEntity.getPassword(), "Passord is not null"),
                () -> Assertions.assertNotNull(userEntity.getEmail(), "Email is null"),
                () -> Assertions.assertNotNull(userEntity.getRole(), "Role is null")
        );
    }

    @Test
    void givenMapperAndEntity_whenForm_thenModelisNotNull() {
        //given
        UserEntity userEntity = new UserEntity();
        UserMapper userMapper = new UserMapper();

        userEntity.setId(1L);
        userEntity.setUsername("kkk");
        userEntity.setEmail("kkk@wp.pl");
        userEntity.setPassword("password");
        userEntity.setRole("ROLE_USER");

        //when

        UserModel userModel = userMapper.form(userEntity);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(userModel.getId(), "Id is null"),
                () -> Assertions.assertNotNull(userModel.getUsername(), "Username is null"),
                () -> Assertions.assertNotNull(userModel.getPassword(), "Passord is not null"),
                () -> Assertions.assertNotNull(userModel.getEmail(), "Email is null"),
                () -> Assertions.assertNotNull(userModel.getRole(), "Role is null")
        );
    }


}