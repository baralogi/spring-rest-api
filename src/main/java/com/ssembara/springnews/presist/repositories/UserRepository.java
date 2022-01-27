package com.ssembara.springnews.presist.repositories;

import com.ssembara.springnews.presist.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
