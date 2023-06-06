package ma.suptech.MSorganization.services;

import ma.suptech.MSorganization.entities.Department;

import java.util.List;

public interface DepartmentService {
    Department create(Department department);
    Department update(Department department);
    Department find(Long id);
    List<Department> list();
    void delete(Long id);
}
