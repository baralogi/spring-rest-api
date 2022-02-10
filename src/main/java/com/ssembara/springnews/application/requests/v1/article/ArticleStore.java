package com.ssembara.springnews.application.requests.v1.article;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ArticleStore {

    @NotNull(message = "not null")
    @NotBlank(message = "not blank")
    private String title;

    @NotNull(message = "not null")
    @NotBlank(message = "not blank")
    private String description;

    private Long authorId;
}
