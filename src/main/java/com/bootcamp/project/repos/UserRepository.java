package com.bootcamp.project.repos;

import com.bootcamp.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User getUserByUserID(UUID id);
    User getUserByEmail(String email);
}
