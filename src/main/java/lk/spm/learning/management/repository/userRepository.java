package lk.spm.learning.management.repository;

import lk.spm.learning.management.model.Item;

import lk.spm.learning.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User, String>{
}


