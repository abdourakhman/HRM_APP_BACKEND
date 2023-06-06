package ma.suptech.MShuman.services;



import ma.suptech.MShuman.models.HumanResourceManager;

import java.util.List;

public interface HumanResourceManagerService {

    List<HumanResourceManager> listRH();
    List<HumanResourceManager>  findByDepartment(Long id);
    HumanResourceManager find(Long id);
    HumanResourceManager save(HumanResourceManager humanResourceManager);
    HumanResourceManager update(HumanResourceManager humanResourceManager);
    void delete(Long id);
}
