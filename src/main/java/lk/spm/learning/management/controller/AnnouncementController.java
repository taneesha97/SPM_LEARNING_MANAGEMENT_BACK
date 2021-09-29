package lk.spm.learning.management.controller;

import lk.spm.learning.management.model.AnnouncementModel;
import lk.spm.learning.management.model.Class;
import lk.spm.learning.management.model.Course;
import lk.spm.learning.management.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AnnouncementController {

    @Autowired
    AnnouncementRepository announcementRepository;

    //GET ANNOUNCEMENTS
    @GetMapping("/announcements")
    public ResponseEntity<?> getClasses(){
        List<AnnouncementModel> classes = announcementRepository.findAll();
        if(classes.size() > 0){
            return new ResponseEntity<>(classes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Announcements Available", HttpStatus.NOT_FOUND);
        }
    }

    //INSERT ANNOUNCEMENT
    //SAVE EMPLOYEE
    @PostMapping("/announcement")
    public ResponseEntity<?> createCourse(@RequestBody AnnouncementModel announcement){
        try {
            announcementRepository.save(announcement);
            return new ResponseEntity<AnnouncementModel>(announcement, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
