package lk.spm.learning.management.repository;

import lk.spm.learning.management.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface loginUserRepository {
    String validateUser (@RequestBody User user);
}
