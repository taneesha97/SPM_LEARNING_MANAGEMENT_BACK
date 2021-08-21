package lk.spm.learning.management.repository.Impl;

import lk.spm.learning.management.model.User;
import lk.spm.learning.management.repository.loginUserRepository;
import lk.spm.learning.management.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static lk.spm.learning.management.repository.Impl.Query.USERS;

@Repository
public class UserImplementation implements loginUserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public String validateUser(User user) {
        String sql = "SELECT type FROM users WHERE username=? AND password=?";
        try {
            String type = jdbcTemplate.queryForObject(sql, new Object[] {
                    user.getUsername(), user.getPassword() }, String.class);
            return type;
        } catch (Exception e) {
            return null;
        }
    }
}
