package com.ssembara.springnews.application.controllers.v1;

import com.ssembara.springnews.application.responses.ResponseGlobal;
import com.ssembara.springnews.presist.services.ArticleService;
import com.ssembara.springnews.utility.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/articles")
@AllArgsConstructor
public class ArticleController {

    private ArticleService service;

    @GetMapping
    public ResponseEntity<ResponseGlobal> index() {
        var data = service.getAll();
        return Response.buildV1(data);
    }

}
