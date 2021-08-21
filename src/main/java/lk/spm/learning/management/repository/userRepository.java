package lk.spm.learning.management.repository;

import lk.spm.learning.management.model.Item;

import lk.spm.learning.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.NamedQuery;

@Repository
public interface userRepository extends JpaRepository<User, Long>{
    //@NamedQuery( "{ 'userName' : ?0, 'password' : ?0 }")
    //@Query("SELECT u.username FROM User  u WHERE u.username = 'salitha'")
//    @Query(name = "username")
//    @Query("SELECT u.username FROM User  u WHERE u.username = 'salitha'")
//    User findUserByUsername(String username);

}


