package ma.suptech.MSresource.services;



import ma.suptech.MSresource.models.Contract;

import java.util.List;
import java.util.Map;

public interface ContractService {
    Contract create(Contract contract);
    Contract update(Contract contract);
    Contract find(Long id);
    List<Contract> findByEmployee(Long id);
    List<Contract>  findAll();
    Map<String,Integer> getNumberOfDistinctContract();
    float getAverageSalary();
    void remove(Long id);
}
