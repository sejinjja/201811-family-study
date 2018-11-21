package com.study.todo;

import lombok.Data;

@Data
public class StdResponse<T> {
    private int code = 500;
    private String message = "error";
    private T payload = null;
}
