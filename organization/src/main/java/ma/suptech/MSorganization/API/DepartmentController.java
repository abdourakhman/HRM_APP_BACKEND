package ma.suptech.MSorganization.API;

import ma.suptech.MSorganization.entities.Department;
import ma.suptech.MSorganization.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/department")
    public Department create(@RequestBody Department department){
        return departmentService.create(department);
    }

    @PutMapping("/department")
    public Department update(@RequestBody Department department){
        return departmentService.update(department);
    }

    @GetMapping("/departments/{id}")
    public Department find(@PathVariable Long id){
        return departmentService.find(id);
    }

    @GetMapping("/departments")
    public List<Department> list(){
        return departmentService.list();
    }

    @DeleteMapping("/department/{id}")
    public void delete(@PathVariable Long id){
        departmentService.delete(id);
    }
}
