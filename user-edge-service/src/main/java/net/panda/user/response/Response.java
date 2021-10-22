package net.panda.user.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Response implements Serializable {
    public static final Response USERNAME_PASSWORD_ERROR = new Response("1001", "username or password is not correct");
    private String code;
    private String message;

    public Response() {
        message = "success";
        code = "0";
    }
}
