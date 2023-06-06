package ma.suptech.MShuman.services;


import ma.suptech.MShuman.models.Manager;

import java.util.List;

public interface ManagerService {

    List<Manager> listManager();
    List<Manager> findByJob(Long id);
    List<Manager>  findByDepartment(Long id);
    Manager find(Long id);
    Manager save(Manager manager);
    Manager update(Manager manager);
    void delete(Long id);
}
