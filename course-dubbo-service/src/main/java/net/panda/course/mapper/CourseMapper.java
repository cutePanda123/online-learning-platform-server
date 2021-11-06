package net.panda.course.mapper;

import net.panda.course.dto.CourseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select * from pe_course")
    List<CourseDTO> listCourses();

    @Select("select user_id from pr_user_course where course_id=#{courseId}")
    Integer getCourseTeacher(@Param("courseId") int courseId);
}
