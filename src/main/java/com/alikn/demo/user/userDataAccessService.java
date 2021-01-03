package com.alikn.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class userDataAccessService {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public userDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<User> selectAllUsers() {
        String sql = "SELECT user_id, first_name, last_name, email, gender FROM app_user";
        List<User> users = jdbcTemplate.query(sql, mapUserFromDB());
        return users;
    }

    private RowMapper<User> mapUserFromDB() {
        return (resultSet, i) -> {
            String userIdStr = resultSet.getString("user_id");
            UUID userId = UUID.fromString(userIdStr);
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String genderStr = resultSet.getString("gender").toUpperCase();
            User.Gender gender = User.Gender.valueOf(genderStr);
            return new User(userId, firstName, lastName, email, gender);
        };
    }

    int insertUser(UUID userId, User user) {
        String query = "INSERT INTO app_user (user_id, first_name, last_name, email, gender) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(
                query,
                userId,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getGender().name().toUpperCase()
        );
    }
}
