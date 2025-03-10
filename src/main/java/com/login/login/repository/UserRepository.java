package com.login.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.login.login.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    List<User> findByUsernameContaining(String keyword);
    List<User> findByEmailContaining(String keyword);


}
