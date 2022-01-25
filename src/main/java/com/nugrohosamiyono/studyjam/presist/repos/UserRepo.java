package com.nugrohosamiyono.studyjam.presist.repos;

import com.nugrohosamiyono.studyjam.presist.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    
}
