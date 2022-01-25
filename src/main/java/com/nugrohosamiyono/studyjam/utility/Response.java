package com.nugrohosamiyono.studyjam.utility;

import com.nugrohosamiyono.studyjam.application.dto.ResponseGlobal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

    public static ResponseEntity<ResponseGlobal> buildV1(Object data) {
        var res = new ResponseGlobal();
        res.setCode(0);
        res.setStatus("OK");
        res.setData(data);

        return new ResponseEntity<ResponseGlobal>(res, HttpStatus.OK);
    }
}
