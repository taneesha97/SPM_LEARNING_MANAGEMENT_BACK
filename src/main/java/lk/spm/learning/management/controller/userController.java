package lk.spm.learning.management.controller;

import lk.spm.learning.management.model.User;
import lk.spm.learning.management.model.loginUser;
import lk.spm.learning.management.repository.userRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class userController {
    @Autowired
    private userRepository userRepository;

    private final Logger log = LoggerFactory.getLogger(userController.class);

    public userController(userRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userRepository.findAll();
        if(users.size() > 0){
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No User Available", HttpStatus.NOT_FOUND);
        }
    }


    //Add user
    @PostMapping("/user")
    public ResponseEntity<?> createUser( @RequestBody User user) {
        try {
            System.out.println("user is " + user);
            userRepository.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //Get Single user
    @GetMapping("/getsingleuser/{id}")
    public ResponseEntity<?> getSingleUser(@PathVariable("id") String id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No User Available", HttpStatus.NOT_FOUND);
        }
    }


    //Update user
    @PutMapping("/updateuser/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody User user){
        Optional<User> userUpdate = Optional.ofNullable(userRepository.getById(id));
        System.out.println("user updated " + userUpdate.isPresent());
        if(userUpdate.isPresent()){
            User updateUser = userUpdate.get();
            //updateUser.setId(user.getId()  != null ? user.getId() : updateUser.getId());
            updateUser.setName(user.getName() != null ? user.getName() : updateUser.getName());
            updateUser.setEmail(user.getEmail() != null ? user.getEmail() : updateUser.getEmail());
            updateUser.setUsername(user.getUsername() != null ? user.getUsername() : updateUser.getUsername());
            updateUser.setPassword(user.getPassword() != null ? user.getPassword() : updateUser.getPassword());
            updateUser.setType(user.getType() != null ? user.getType() : updateUser.getType());
            userRepository.save(user);
            return new ResponseEntity<>("Update Successful", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No User Available", HttpStatus.NOT_FOUND);
        }
    }


    //Delete user
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id){
        userRepository.deleteById(id);
        return new ResponseEntity<>("delete unsuccessful", HttpStatus.OK);
    }

}


