package com.ssembara.studyjam.application.controllers.v1;

import com.ssembara.studyjam.application.dto.ResponseGlobal;
import com.ssembara.studyjam.application.request.v1.category.CategoryStore;
import com.ssembara.studyjam.application.request.v1.category.CategoryUpdate;
import com.ssembara.studyjam.presist.services.CategoryService;
import com.ssembara.studyjam.utility.Response;

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
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService useCase;

    @GetMapping
    public ResponseEntity<ResponseGlobal> index() {
        var data = useCase.getAll();
        return Response.buildV1(data);
    }

    @PostMapping
    public ResponseEntity<ResponseGlobal> store(
            @RequestBody CategoryStore data) {
        useCase.storeCategory(data);
        return Response.buildV1("Success create data");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseGlobal> show(@PathVariable Long id) throws Exception {
        var data = useCase.showCategory(id);
        return Response.buildV1(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseGlobal> update(@PathVariable Long id,
            @RequestBody CategoryUpdate data) throws Exception {
        useCase.updateCategory(id, data);
        return Response.buildV1("Success update data");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseGlobal> delete(@PathVariable Long id) throws Exception {
        useCase.destroyCategory(id);
        return Response.buildV1("Success delete data");
    }

}
