package pl.coderslab.charity.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dao.entity.UserEntity;
import pl.coderslab.charity.dao.repository.UserRepository;
import pl.coderslab.charity.service.mapper.UserMapper;
import pl.coderslab.charity.web.model.UserModel;

@Service
@Transactional
public class UserMenagerService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserMenagerService(UserMapper userMapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserModel user) {
        UserEntity userEntity = userMapper.form(user);
        String encodePassword = passwordEncoder.encode(user.getPassword());
        userEntity.setPassword(encodePassword);
        userEntity.setRole("ROLE_USER");
        userRepository.save(userEntity);
    }
}
