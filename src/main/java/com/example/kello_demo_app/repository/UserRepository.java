package com.example.kello_demo_app.repository;

import com.example.kello_demo_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByTeam(String team);
}
