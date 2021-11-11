package net.panda.course.service;

import net.panda.course.dto.CourseDTO;
import net.panda.course.mapper.CourseMapper;
import net.panda.thrift.user.UserInfo;
import net.panda.thrift.user.dto.TeacherDTO;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ServiceProvider serviceProvider;

    @Override
    public List<CourseDTO> listCourse() {
        List<CourseDTO> courseDTOList = courseMapper.listCourses();
        if (courseDTOList == null) {
            return null;
        }
        for (CourseDTO courseDTO : courseDTOList) {
            Integer teacherId = courseMapper.getCourseTeacher(courseDTO.getId());
            if (teacherId != null) {
                UserInfo userInfo = null;
                try {
                    userInfo = serviceProvider.getUserService().getTeacherById(teacherId);
                } catch (TException e) {
                    e.printStackTrace();
                    return null;
                }
                courseDTO.setTeacher(trans2Teacher(userInfo));
            }
        }
        return courseDTOList;
    }

    private TeacherDTO trans2Teacher(UserInfo userInfo) {
        TeacherDTO teacherDTO = new TeacherDTO();
        BeanUtils.copyProperties(userInfo, teacherDTO);
        return teacherDTO;
    }
}
