package com.turntalien.userservice.controller;

import com.turntalien.userservice.VO.ResponseTemplateVo;
import com.turntalien.userservice.entity.Users;
import com.turntalien.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public Users saveUser(@RequestBody Users users) {
        log.info("saveUser()");
        return userService.saveUser(users);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("getUserWithDepartment");
        return userService.getUserWithDepartment(userId);
    }
}
