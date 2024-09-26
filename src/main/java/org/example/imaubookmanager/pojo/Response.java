package org.example.imaubookmanager.pojo;

public class Response<T> {
    private boolean success;
    private String message;
    private T data;

    public Response(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(true, "操作成功", data);
    }

    public static <T> Response<T> failure(String message, T data) {
        return new Response<>(false, message, data); // data 允许为 null
    }

    // Getters and setters
}
