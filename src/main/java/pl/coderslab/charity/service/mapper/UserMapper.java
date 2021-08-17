package pl.coderslab.charity.service.mapper;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.dao.entity.UserEntity;
import pl.coderslab.charity.web.model.UserModel;

import javax.persistence.Column;

@Component
public class UserMapper {

    public UserEntity form(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userModel.getId());
        userEntity.setUsername(userModel.getUsername());
        userEntity.setPassword(userModel.getPassword());
        userEntity.setEmail(userModel.getEmail());
        userEntity.setRole(userModel.getRole());
        return userEntity;
    }

    public UserModel form(UserEntity userEntity) {
        UserModel userModel = new UserModel();
        userModel.setId(userEntity.getId());
        userModel.setUsername(userEntity.getUsername());
        userModel.setPassword(userEntity.getPassword());
        userModel.setEmail(userEntity.getEmail());
        userModel.setRole(userEntity.getRole());
        return userModel;
    }


}
