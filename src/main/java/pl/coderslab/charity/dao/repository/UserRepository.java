package pl.coderslab.charity.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.dao.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity , Long> {
    Optional<UserEntity> findByUsername(String username);
}
