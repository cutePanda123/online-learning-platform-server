package net.panda.thrift.user.dto;

import lombok.Data;

@Data
public class TeacherDTO extends UserDTO{
    private String intro;
    private int stars;
}
