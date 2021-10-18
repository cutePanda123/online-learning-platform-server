package net.panda.user.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    public static final Response USERNAME_PASSWORD_ERROR = new Response("1001", "username or password is not correct");
    private String code;
    private String message;
}
