package net.panda.course.dto;

import lombok.Data;
import net.panda.thrift.user.dto.TeacherDTO;

@Data
public class CourseDTO {
    private int id;
    private String title;
    private String description;
    private TeacherDTO teacher;
}
