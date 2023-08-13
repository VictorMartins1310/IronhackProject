package com.bootcamp.project.repos;

import com.bootcamp.project.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDetailsRepository extends JpaRepository<UserDetails, UUID> {

}
