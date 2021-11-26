package net.panda.course.filter;

import net.panda.user.client.LoginFilter;
import net.panda.thrift.user.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CourseFilter extends LoginFilter {
    @Override
    protected void postLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, UserDTO userDTO) {
        httpServletRequest.setAttribute("user", userDTO);
    }
}
