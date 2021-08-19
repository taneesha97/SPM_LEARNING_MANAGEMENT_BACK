package lk.spm.learning.management.controller;


import lk.spm.learning.management.model.User;
import lk.spm.learning.management.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class userController {
    @Autowired
    userRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        // itemRepository.save();
        return null;
    }

    //Add user
    @PostMapping("/item")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return null;
    }

    //Get Single user
    @GetMapping("/getsingleuser/{id}")
    public ResponseEntity<?> getSingleUser(@PathVariable("id") String id){
        return null;
    }

    //Update user
    @PutMapping("/updateuser/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody User user){
        return null;
    }

    //Delete Item
    @DeleteMapping("/deleteitem/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") String id){
        return null;
    }
}


