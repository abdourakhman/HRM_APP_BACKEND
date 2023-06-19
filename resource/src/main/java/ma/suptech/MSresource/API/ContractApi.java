package ma.suptech.MSresource.API;


import ma.suptech.MSresource.models.Contract;
import ma.suptech.MSresource.services.ContractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContractApi {

    private final ContractService contractService;

    public ContractApi(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping("/contract")
    public Contract save(@RequestBody Contract contract){
        return contractService.create(contract);
    }

    @PutMapping("/contract")
    public Contract update(@RequestBody Contract contract){
        return contractService.update(contract);
    }

    @GetMapping("/contracts/{id}")
    public Contract find(@PathVariable Long id){
        return contractService.find(id);
    }

    @GetMapping("/contracts/employee/{id}")
    public List<Contract> findEmployeeContract(@PathVariable Long id){
        return contractService.findByEmployee(id);
    }

    @GetMapping("/contracts")
    public List<Contract> getAllContract(){
        return contractService.findAll();
    }

    @GetMapping("/contracts/average/salary")
    public float getAverageSalary(){
        return contractService.getAverageSalary();
    }

    @DeleteMapping("/contract/{id}")
    public void remove(@PathVariable Long id){
        contractService.remove(id);
    }
}
