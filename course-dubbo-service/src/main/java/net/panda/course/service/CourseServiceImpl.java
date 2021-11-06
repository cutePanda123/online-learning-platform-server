package net.panda.course.service;

import net.panda.course.dto.CourseDTO;
import net.panda.course.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<CourseDTO> listCourse() {
        List<CourseDTO> courseDTOList = courseMapper.listCourses();
        if (courseDTOList == null) {
            return null;
        }
        for (CourseDTO courseDTO : courseDTOList) {
            Integer teacherId = courseMapper.getCourseTeacher(courseDTO.getId());
            if (teacherId)
        }
        return null;
    }
}
