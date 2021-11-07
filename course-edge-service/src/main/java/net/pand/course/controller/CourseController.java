package net.pand.course.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import net.panda.course.dto.CourseDTO;
import net.panda.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Reference
    private ICourseService courseService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<CourseDTO> listCourse() {
        return courseService.listCourse();
    }
}
