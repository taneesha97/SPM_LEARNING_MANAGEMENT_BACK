package lk.spm.learning.management.controller;


import lk.spm.learning.management.model.User;
import lk.spm.learning.management.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class userController {
    @Autowired
    userRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        // itemRepository.save();
        return (ResponseEntity<?>) userRepository.findAll();
    }

    //Add user
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return null;
    }

    //Get Single user
    @GetMapping("/getsingleuser/{id}")
    public ResponseEntity<?> getSingleUser(@PathVariable("id") String id){
        Optional<User> user = userRepository.findById(id);
        return user.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Update user
    @PutMapping("/updateuser/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody User user){
        User result = userRepository.save(user);
        return ResponseEntity.ok().body(result);
    }

    //Delete user
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}


