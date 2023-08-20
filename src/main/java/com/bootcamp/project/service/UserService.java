package com.bootcamp.project.service;

import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.model.ToDoList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.repos.ShoppingListRepository;
import com.bootcamp.project.repos.TaskListRepository;
import com.bootcamp.project.repos.ToDoListRepository;
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
    private final ShoppingListRepository shoppingRepo;
    private final TaskListRepository taskListRepo;

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

    /** Creates a new User and automaticly add an Default TodoList that is a TaskList
     * @param user
     * @return User Object
     */
    public User newUser(User user){
        User savedUser = userRepo.save(user);
        TaskList taskList = new TaskList("First Task List", savedUser);
        taskListRepo.save(taskList);
        return savedUser;
    }
    public User getUser(UUID id){ return userRepo.getUserByUserID(id); }

    // UserDetails Section

    public User findUserDetailsByUserID(UUID id){ return userRepo.getUserByUserID(id); }
    public User updateDetails(UUID id, User details){
        User userDetails = userRepo.getUserByUserID(id);
        userDetails.updateDetails(details.getEmail(), details.getFirstName(), details.getLastName(), details.getBirthDate());
        return userRepo.save(userDetails);
    }
}