package com.ssembara.studyjam.presist.repositories;

import com.ssembara.studyjam.presist.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
