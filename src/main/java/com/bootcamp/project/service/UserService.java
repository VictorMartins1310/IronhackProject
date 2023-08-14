package com.bootcamp.project.service;

import com.bootcamp.project.model.User;
import com.bootcamp.project.repos.UserDetailsRepository;
import com.bootcamp.project.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    /* This UserService Class haves 2 Repositories
     * Separated start with userDetails methods
     */
    private final UserDetailsRepository userDetailsRepo;


    public UserDetails getUserDetails(){
        return null;
    }
    public UserDetails getUserDetails(Long id){
        return null;
    }


    private final UserRepository userRepo;

    public User newUser(User user){
        return userRepo.save(user);
    }

    public User getUser(UUID id){
        return userRepo.getUserByUserID(id);
    }
    public User getUserByEmail(String email){
        return userRepo.getUserByEmail(email);
    }
    public UUID getUUID(String email){
        User u = getUserByEmail(email);
        return u.getUserID();
    }
}