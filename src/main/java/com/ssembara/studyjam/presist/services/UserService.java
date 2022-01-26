package com.ssembara.studyjam.presist.services;

import java.util.List;

import com.ssembara.studyjam.application.request.v1.user.UserStore;
import com.ssembara.studyjam.application.request.v1.user.UserUpdate;
import com.ssembara.studyjam.presist.models.User;
import com.ssembara.studyjam.presist.repositories.UserRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repo;

    public List<User> getAll() {
        return repo.findAll();
    }

    public void storeUser(UserStore userStore) {
        var newUser = new User();
        newUser.setEmail(userStore.getEmail());
        newUser.setPassword(userStore.getPassword());
        newUser.setName(userStore.getName());

        saveUser(newUser);
    }

    public void updateUser(Long id, UserUpdate userUpdate) throws Exception {
        var oldUser = repo.findById(id).orElseThrow(() -> new Exception("data not found"));
        oldUser.setName(userUpdate.getName());

        saveUser(oldUser);
    }

    public void deleteUser(Long id) throws Exception {
        repo.deleteById(id);
    }

    private void saveUser(User user) {
        repo.save(user);
    }
}
