package com.turntalien.departmentservice.service;

import com.turntalien.departmentservice.entity.Department;
import com.turntalien.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("saveDepartment service");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("FindDepartmentById service");
        return departmentRepository.findByDepartmentId(departmentId);

    }
}
