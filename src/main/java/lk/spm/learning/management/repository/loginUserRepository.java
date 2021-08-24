package lk.spm.learning.management.repository;

import lk.spm.learning.management.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface loginUserRepository {
    String validateUser (@RequestBody User user);
//    List<User>  getStudentList();//User
    List<User> getStudentList();
    List<User> getTeacherList();
    String getTeacherStatus(@RequestBody User user);
}
