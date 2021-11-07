package net.panda.thrift.user.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class UserDTO implements Serializable {
    private int id;
    private String username;
    private String password;
    private String mobile;
    private String email;
    private String realName;
}
