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

    // UserDetails Section

    private final UserDetailsRepository userDetailsRepo;
    public UserDetails findUserDetailsByUserID(UUID id){
        return userDetailsRepo.findUserDetailsByUserID(id);
    }

    public UserDetails updateDetails(UUID id, UserDetails details){
/*      Solution 1
        UserDetails userDetails = new UserDetails(details.getFirstName(), details.getLastName(), details.getBirthDate());
        UserDetails details2delete = userDetailsRepo.findById(id).get();
        userDetailsRepo.delete(details2delete);
 */
        UserDetails userDetails = userDetailsRepo.findUserDetailsByUserID(id);
        userDetails.setFirstName(details.getFirstName());
        userDetails.setLastName(details.getLastName());
        userDetails.setBirthDate(details.getBirthDate());
        return userDetailsRepo.save(userDetails);
    }
    public UserDetails addDetails(UserDetails userDetails) {
        return userDetailsRepo.save(userDetails);
    }
}