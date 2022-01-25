package com.ssembara.studyjam.application.dto;

import lombok.Data;

@Data
public class ResponseGlobal {

    private int code;
    private String status;
    private Object data;

}
