package com.ssembara.springnews.presist.services.user;

import java.util.List;
import java.util.Optional;

import com.ssembara.springnews.presist.models.Role;
import com.ssembara.springnews.presist.models.User;

public interface UserInterface {
    User storeUser(User user);

    Role storeRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    Optional<User> getById(Long id);

    List<User> getUsers();
}
