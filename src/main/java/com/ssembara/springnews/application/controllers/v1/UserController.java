package com.ssembara.springnews.application.controllers.v1;

import java.net.URI;
import java.util.List;

import com.ssembara.springnews.application.requests.v1.user.UserStore;
import com.ssembara.springnews.application.requests.v1.user.UserUpdate;
import com.ssembara.springnews.application.responses.ResponseGlobal;
import com.ssembara.springnews.presist.models.Role;
import com.ssembara.springnews.presist.models.User;
import com.ssembara.springnews.presist.services.user.UserService;
import com.ssembara.springnews.utility.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<User> storeUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/users").toUriString());
        return ResponseEntity.created(uri).body(userService.storeUser(user));
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> storeRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/roles").toUriString());
        return ResponseEntity.created(uri).body(userService.storeRole(role));
    }

    @PostMapping("/roles/addtouser")
    public ResponseEntity<?> AddRoleToUser(@RequestBody RoleToUserFrom form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @Data
    class RoleToUserFrom {
        private String username;
        private String roleName;
    }
}
