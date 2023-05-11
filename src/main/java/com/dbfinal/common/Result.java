package com.dbfinal.common;

import lombok.Data;

import java.io.Serializable;

/**
 * In order to return the specific format to frontend, I create this Result class.
 * In this class, I create some success and fail return format.
 * so, in the AccountController and BlogController,
 * I can use these format as return
 *
 * I also set some specific return code. If code = 200, then success. If code equals other number, then fail.
 */
@Data
public class Result implements Serializable {

    private int code;
    private String message;
    private Object data;

    public static Result success(Object data) {
        return success(200, "operation success", data);
    }

    public static Result success(int code, String message, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static Result fail(String msg) {
        return fail(400, msg, null);
    }

//    public static Result fail(String msg, Object data) {
//        return fail(400, msg, data);
//    }

    public static Result fail(int code, String message, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}

