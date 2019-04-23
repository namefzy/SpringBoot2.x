package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepostitory extends JpaRepository<User,Long> {
    /**
     * 封装了基本的crud
     * @param username
     * @return
     */
    List<User> findAllByUsername(String username);
}
