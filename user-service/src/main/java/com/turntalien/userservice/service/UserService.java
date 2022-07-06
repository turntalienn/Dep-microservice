package com.turntalien.userservice.service;

import com.turntalien.userservice.VO.Department;
import com.turntalien.userservice.VO.ResponseTemplateVo;
import com.turntalien.userservice.entity.Users;
import com.turntalien.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Users saveUser(Users users) {
        log.info("saveUser service...");
        return userRepository.save(users);
    }

    public ResponseTemplateVo getUserWithDepartment(Long userId) {
        log.info("ResponseTemplateVo()");
        ResponseTemplateVo vo = new ResponseTemplateVo();
        Users users = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE:9001/departments/"
                        + users.getDepartmentId(), Department.class);

        vo.setUsers(users);
        vo.setDepartment(department);

        return vo;
    }
}
