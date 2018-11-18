package com.study.gallery;

import lombok.Data;

@Data
public class StdResponse<T> {
    private int code;
    private String message;
    private T payload;
}
