package lk.spm.learning.management.controller;

import lk.spm.learning.management.model.Announcement;
import lk.spm.learning.management.model.Class;
import lk.spm.learning.management.repository.AnnouncementRepository;
import lk.spm.learning.management.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AnnouncementController {

    @Autowired
    AnnouncementRepository announcementRepository;

    //GET ann
    @GetMapping("/announcements")
    public ResponseEntity<?> getAnnouncements(){
        List<Announcement> announcements = announcementRepository.findAll();
        if(announcements.size() > 0){
            return new ResponseEntity<>(announcements, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Announcements Available", HttpStatus.NOT_FOUND);
        }
    }




}
