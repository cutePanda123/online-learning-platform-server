package net.panda.course.dto;

import lombok.Data;
import net.panda.thrift.user.dto.TeacherDTO;

import java.io.Serializable;

@Data
public class CourseDTO implements Serializable {
    private int id;
    private String title;
    private String description;
    private TeacherDTO teacher;
}
