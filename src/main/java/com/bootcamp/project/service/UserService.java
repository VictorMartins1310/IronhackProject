package com.bootcamp.project.service;

import com.bootcamp.project.model.User;
import com.bootcamp.project.model.UserDetails;
import com.bootcamp.project.repos.UserDetailsRepository;
import com.bootcamp.project.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    /* This UserService Class haves 2 Repositories
     * Separated start with userDetails methods
     */
    private final UserRepository userRepo;

    public List<User> showUsers(){
        return userRepo.findAll();
    }
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

    // UserDetails Section

    private final UserDetailsRepository userDetailsRepo;
    public UserDetails findDetailsByUserID(UUID id){
        return userDetailsRepo.findById(id).get();
    }

    public UserDetails updateDetails(UUID id, UserDetails details){

        UserDetails userDetails = new UserDetails(details.getFirstName(), details.getLastName(), details.getBirthDate());
        UserDetails details2delete = userDetailsRepo.findById(id).get();
        userDetailsRepo.delete(details2delete);
        return userDetailsRepo.save(userDetails);
    }


}