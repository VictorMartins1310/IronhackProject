package com.bootcamp.project.service;

import com.bootcamp.project.dto.DTOUser;
import com.bootcamp.project.mappers.UserMapper;
import com.bootcamp.project.model.Role;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.repos.RoleRepository;
import com.bootcamp.project.repos.TaskListRepository;
import com.bootcamp.project.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    // Repositories
    /**
     * Autowired UserRepository for database operations.
     */
    private final TaskListRepository taskListRepo;
    /**
     * Autowired RoleRepository for database operations.
     */
    private final RoleRepository roleRepository;
    private final UserRepository userRepo;

    // Mappers
    private final UserMapper userMapper;

    public long qtyUsers(){ return userRepo.count(); }

    /**
     * Injects a bean of type PasswordEncoder into this class.
     * The bean is used for encoding passwords before storing them.
     */
    private final PasswordEncoder passwordEncoder;


    /** Show all Users a funtion for a Admin
     * @return List of Users
     */
    public List<User> showUsers(){  return userRepo.findAll(); }

    /** Create new User introducing E-mail and Password
     * @param email Registered E-Mail adress
     * @param password Password
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
        save(user, "ROLE_ADMIN");
        return userRepo.save(user);
    }

    /** Creates a new User
     * In case dont exist an User it will create an User with ADMIN ROLE
     * Otherwise it creates an User with an Default TaskList and USER ROLE
     * @param user
     * @return User Object
     */

    public User save(User user, String role){
        user.addRole(addRole(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public User newUser(User user){
        if (qtyUsers() == 0) {
            return newAdmin(user);
        } else {
            save(user, "ROLE_USER");
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
    /** Loads the user by its username, in this case the email adress
     *
     * @param email the username to search for
     * @return the UserDetails object that matches the given username
     * @throws UsernameNotFoundException if the user with the given username is not found
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Retrieve user with the given username
        User user = userRepo.getUserByEmail(email);
        // Check if user exists
        if (user == null) {
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            // Create a collection of SimpleGrantedAuthority objects from the user's roles
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getRole()));
            });
            // Return the user details, including the username, password, and authorities
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
        }
    }
}