package net.panda.course.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import net.panda.course.dto.CourseDTO;
import net.panda.course.service.ICourseService;
import net.panda.thrift.user.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Reference
    private ICourseService courseService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    @ResponseBody
    public List<CourseDTO> listCourse(HttpServletRequest request) {
        UserDTO userDTO = (UserDTO)request.getAttribute("user");
        System.out.println(userDTO.toString());

        return courseService.listCourse();
    }
}
