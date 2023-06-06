package ma.suptech.MSorganization.services;

import ma.suptech.MSorganization.entities.Department;
import ma.suptech.MSorganization.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department update(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department find(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Department> list() {
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(department -> departments.add(department));
        return departments;
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }
}
