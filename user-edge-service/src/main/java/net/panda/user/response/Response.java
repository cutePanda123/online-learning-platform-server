package net.panda.user.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Response implements Serializable {
    public static final Response USERNAME_PASSWORD_ERROR = new Response("1001", "username or password is not correct");
    public static final Response MOBILE_OR_EMAIL_ERROR = new Response("1002", "mobile or email is not correct");
    public static final Response SEND_VERIFICATION_CODE_ERROR = new Response("1003", "send verification code failure");
    public static final Response SUCCESS = new Response();
    private String code;
    private String message;

    public Response() {
        message = "success";
        code = "0";
    }

    public static Response exception(Exception e) {
        return new Response("9999", e.getMessage());
    }
}
