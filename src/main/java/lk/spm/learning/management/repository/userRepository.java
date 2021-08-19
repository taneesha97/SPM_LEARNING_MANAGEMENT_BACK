package lk.spm.learning.management.repository;

import lk.spm.learning.management.model.Item;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User, String>{
}


