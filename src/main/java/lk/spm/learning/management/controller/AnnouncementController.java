package lk.spm.learning.management.controller;

import lk.spm.learning.management.model.Announcement;
import lk.spm.learning.management.model.Class;
import lk.spm.learning.management.repository.AnnouncementRepository;
import lk.spm.learning.management.repository.ClassRepository;
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

    //GET announcements
    @GetMapping("/announcements")
    public ResponseEntity<?> getAnnouncements(){
        List<Announcement> announcements = announcementRepository.findAll();
        if(announcements.size() > 0){
            return new ResponseEntity<>(announcements, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Announcements Available", HttpStatus.NOT_FOUND);
        }
    }

    //get class by id
    @GetMapping("/announcements/{id}")
    public ResponseEntity<?> getAnnouncementById(@PathVariable long id){

        Optional<Announcement> announcements = announcementRepository.findById(id);
        if(announcements.isPresent()){
            return new ResponseEntity<>(announcements.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Announcements Available", HttpStatus.NOT_FOUND);
        }
    }

    //add Announcement
    @PostMapping("/announcement")
    public ResponseEntity<?> createAnnouncement(@RequestBody Announcement announcement){
        try {
            System.out.println("class is " + announcement);
            announcementRepository.save(announcement);
            return new ResponseEntity<Announcement>(announcement, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }




}
