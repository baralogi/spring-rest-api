package com.ssembara.springnews.utility;

import com.ssembara.springnews.application.responses.ResponseGlobal;

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

    public static ResponseEntity<ResponseGlobal> buildErrorV1(Object data) {
        var res = new ResponseGlobal();
        res.setCode(-1);
        res.setStatus("NOT OK");
        res.setData(data);

        return new ResponseEntity<ResponseGlobal>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<ResponseGlobal> buildBadRequestV1(Object data) {
        var res = new ResponseGlobal();
        res.setCode(-2);
        res.setStatus("BAD REQUEST");
        res.setData(data);

        return new ResponseEntity<ResponseGlobal>(res, HttpStatus.BAD_REQUEST);
    }
}
