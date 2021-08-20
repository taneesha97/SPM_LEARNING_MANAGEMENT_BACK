package lk.spm.learning.management.repository;

import lk.spm.learning.management.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class CourseRepository {
    public interface TutorialRepository extends JpaRepository<Course, Long> {
        List<Course> findByPublished(boolean published);

        List<Course> findByTitleContaining(String title);
    }
}
