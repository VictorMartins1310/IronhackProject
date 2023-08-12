package com.bootcamp.project.repos;

import com.bootcamp.project.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

}
