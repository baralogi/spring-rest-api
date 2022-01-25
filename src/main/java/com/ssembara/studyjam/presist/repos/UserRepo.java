package com.ssembara.studyjam.presist.repos;

import com.ssembara.studyjam.presist.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
