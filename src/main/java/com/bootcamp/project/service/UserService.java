package com.bootcamp.project.service;

import com.bootcamp.project.dto.DTOUser;
import com.bootcamp.project.mappers.UserMapper;
import com.bootcamp.project.model.Role;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.repos.RoleRepository;
import com.bootcamp.project.repos.ShoppingListRepository;
import com.bootcamp.project.repos.TaskListRepository;
import com.bootcamp.project.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    // Repositories
    private final UserRepository userRepo;
    private final TaskListRepository taskListRepo;
    private final RoleRepository roleRepository;

    // Mappers
    private final UserMapper userMapper;



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

    /** This Function add new Role or get the Role by Name
      * @param name
     * @return
     */
    public Role addRole(String name){
        if (roleRepository.findByRole(name).isEmpty()) {
            return roleRepository.save(new Role(name));
        }else
            return roleRepository.findByRole(name).get();
    }

    public User getUserByUserEmail(String email){
        return userRepo.getUserByEmail(email);
    }

    public User newAdmin(User user){
        User savedUser = userRepo.save(user);
        savedUser.addRole(addRole("ROLE_ADMIN"));
        userRepo.save(savedUser);
        return savedUser;
    }

    /** Creates a new User and automaticly add an Default TodoList that is a TaskList
     * @param user
     * @return User Object
     */
    public User newUser(User user){
        long qtyUsers = userRepo.count();
        if (qtyUsers == 0) {
            return newAdmin(user);
        } else {
            user.addRole(addRole("ROLE_USER"));
            userRepo.save(user); //Updates the User
            TaskList taskList = new TaskList("First Task List", user);
            taskListRepo.save(taskList);
            return user;
        }
    }
    public User getUser(UUID id){
        return userRepo.getUserByUserID(id);
    }
    public DTOUser getUserDTO(UUID id){
        return userMapper.toDto(userRepo.getUserByUserID(id));
    }
    // UserDetails Section

    public User findUserDetailsByUserID(UUID id){ return userRepo.getUserByUserID(id); }
    public User updateDetails(UUID id, User details){
        User userDetails = userRepo.getUserByUserID(id);
        userDetails.updateDetails(details.getEmail(), details.getFirstName(), details.getLastName(), details.getBirthDate());
        return userRepo.save(userDetails);
    }
}