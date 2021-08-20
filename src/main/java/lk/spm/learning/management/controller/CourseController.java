package lk.spm.learning.management.controller;

import lk.spm.learning.management.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
//    TutorialRepository tutorialRepository;

    @GetMapping("/get")
    public ResponseEntity<String> getAllTutorials() {
//        try {
//            List<Tutorial> tutorials = new ArrayList<Tutorial>();
//
//            if (title == null)
//                tutorialRepository.findAll().forEach(tutorials::add);
//            else
//                tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
//
//            if (tutorials.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(tutorials, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        return new ResponseEntity<String>("Success Get", HttpStatus.CREATED);
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Course> getTutorialById(@PathVariable("id") long id) {
//        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
//
//        if (tutorialData.isPresent()) {
//            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return null;
    }

    @PostMapping("/post")
    public ResponseEntity<String> createTutorial() {
//        try {
//            Tutorial _tutorial = tutorialRepository
//                    .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
//            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }

        return new ResponseEntity<String>("Success Post", HttpStatus.CREATED);

    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Course> updateTutorial(@PathVariable("id") long id, @RequestBody Course tutorial) {
//        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
//
//        if (tutorialData.isPresent()) {
//            Tutorial _tutorial = tutorialData.get();
//            _tutorial.setTitle(tutorial.getTitle());
//            _tutorial.setDescription(tutorial.getDescription());
//            _tutorial.setPublished(tutorial.isPublished());
//            return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return null;
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
//        try {
//            tutorialRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        return null;
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
//        try {
//            tutorialRepository.deleteAll();
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        return null;

    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Course>> findByPublished() {
//        try {
//            List<Tutorial> tutorials = tutorialRepository.findByPublished(true);
//
//            if (tutorials.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(tutorials, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        return null;
    }
}
