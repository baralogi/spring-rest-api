package com.ssembara.springnews.application.controllers.v1;

import com.ssembara.springnews.application.requests.v1.user.UserStore;
import com.ssembara.springnews.application.requests.v1.user.UserUpdate;
import com.ssembara.springnews.application.responses.ResponseGlobal;
import com.ssembara.springnews.presist.services.UserService;
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

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private UserService useCase;

    @GetMapping
    public ResponseEntity<ResponseGlobal> index() {
        var data = useCase.getAll();
        return Response.buildV1(data);
    }

    @PostMapping
    public ResponseEntity<ResponseGlobal> create(
            @RequestBody UserStore userStore) {
        useCase.storeUser(userStore);
        return Response.buildV1("Success create user");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseGlobal> update(@PathVariable Long id,
            @RequestBody UserUpdate userUpdate) throws Exception {
        useCase.updateUser(id, userUpdate);
        return Response.buildV1("Success update user");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseGlobal> delete(@PathVariable Long id) throws Exception {
        useCase.deleteUser(id);
        return Response.buildV1("Success delete user");
    }

}
