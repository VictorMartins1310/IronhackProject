package com.bootcamp.project.service;

import com.bootcamp.project.model.User;
import com.bootcamp.project.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;

    /** Show all Users a funtion for a Admin
     * @return List of Users
     */
    public List<User> showUsers(){  return userRepo.findAll(); }

    /** Create new User introducing E-mail and Password
     * @param email
     * @param password
     * @return User Object
     */
    public User newUser(String email, String password){
        return userRepo.save(new User(email, password));
    }
    public User newUser(User user){ return userRepo.save(user); }
    public User getUser(UUID id){ return userRepo.getUserByUserID(id); }
    public User getUserByEmail(String email){ return userRepo.getUserByEmail(email); }

    // UserDetails Section

    public User findUserDetailsByUserID(UUID id){ return userRepo.getUserByUserID(id); }
    public User updateDetails(UUID id, User details){
        User userDetails = userRepo.getUserByUserID(id);
        userDetails.updateDetails(details.getEmail(), details.getFirstName(), details.getLastName(), details.getBirthDate());
        return userRepo.save(userDetails);
    }
}