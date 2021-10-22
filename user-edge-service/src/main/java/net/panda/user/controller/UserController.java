package net.panda.user.controller;

import net.panda.thrift.user.UserInfo;
import net.panda.user.dto.UserDTO;
import net.panda.user.redis.RedisClient;
import net.panda.user.response.LoginResponse;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import net.panda.user.response.Response;
import net.panda.user.thrift.ServiceProvider;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private ServiceProvider serviceProvider;

    @Autowired
    private RedisClient redisClient;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestParam("username") String username,
                      @RequestParam("password") String password) {
        UserInfo userInfo = null;
        try {
            userInfo = serviceProvider.getUserService().getUserByName(username);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.USERNAME_PASSWORD_ERROR;
        }
        if (userInfo == null) {
            return Response.USERNAME_PASSWORD_ERROR;
        }
        if (!userInfo.getPassword().equalsIgnoreCase(md5(password))) {
            return Response.USERNAME_PASSWORD_ERROR;
        }
        final String token = UUID.randomUUID().toString().replace("-", "");

        redisClient.set(token, toDTO(userInfo), 3600);
        return new LoginResponse(token);
    }

    private UserDTO toDTO(UserInfo userInfo) {
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(userInfo, dto);
        return dto;
    }

    private String md5(String password) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(password.getBytes("utf-8"));
            return HexUtils.toHexString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
