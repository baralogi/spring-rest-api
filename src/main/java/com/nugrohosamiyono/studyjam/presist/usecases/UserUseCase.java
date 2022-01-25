package com.nugrohosamiyono.studyjam.presist.usecases;

import java.util.List;

import com.nugrohosamiyono.studyjam.application.request.v1.UserCreate;
import com.nugrohosamiyono.studyjam.application.request.v1.UserUpdate;
import com.nugrohosamiyono.studyjam.presist.models.User;
import com.nugrohosamiyono.studyjam.presist.repos.UserRepo;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserUseCase {

    private UserRepo repo;

    public List<User> getAll() {
        return repo.findAll();
    }

    public void createUser(UserCreate userCreate) {
        var newUser = new User();
        newUser.setName(userCreate.getName());
        newUser.setAge(userCreate.getAge());

        saveUser(newUser);
    }

    public void updateUser(Long id, UserUpdate userUpdate) throws Exception {
        var oldUser = repo.findById(id).orElseThrow(() -> new Exception("user tidak ditemukan"));
        oldUser.setAge(userUpdate.getAge());

        saveUser(oldUser);
    }

    public void deleteUser(Long id) throws Exception {
        repo.deleteById(id);
    }

    private void saveUser(User user) {
        repo.save(user);
    }
}
