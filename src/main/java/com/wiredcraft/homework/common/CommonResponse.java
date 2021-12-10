package com.wiredcraft.homework.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

    private T data;

    public static <T> CommonResponse<T> withData(T data) {
        return new CommonResponse<>(data);
    }
}
