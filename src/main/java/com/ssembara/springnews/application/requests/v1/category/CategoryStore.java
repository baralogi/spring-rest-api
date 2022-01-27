package com.ssembara.springnews.application.requests.v1.category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CategoryStore {

    @NotNull(message = "not null")
    @NotBlank(message = "not blank")
    private String name;
}
