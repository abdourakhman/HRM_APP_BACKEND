package ma.suptech.MSresource.services;


import ma.suptech.MSresource.client.HumanRestClient;
import ma.suptech.MSresource.enumerations.Contract.Type;
import ma.suptech.MSresource.models.Contract;
import ma.suptech.MSresource.repositories.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContractServiceImpl implements ContractService {
    private final HumanRestClient humanRestClient;
    private final ContractRepository contractRepository;

    public ContractServiceImpl(HumanRestClient humanRestClient, ContractRepository contractRepository) {
        this.humanRestClient = humanRestClient;
        this.contractRepository = contractRepository;
    }


    @Override
    public Contract create(Contract contract) {
        contract.setHumanResourceManager(humanRestClient.findHumanResourceManager(contract.getHumanResourceManagerID()));
        contract.setEmployee(humanRestClient.findEmployee(contract.getEmployeeID()));
        return  contractRepository.save(contract);
    }

    @Override
    public Contract update(Contract contract) {
        contract.setHumanResourceManager(humanRestClient.findHumanResourceManager(contract.getHumanResourceManagerID()));
        contract.setEmployee(humanRestClient.findEmployee(contract.getEmployeeID()));
        return  contractRepository.save(contract);
    }

    @Override
    public Contract find(Long id) {
        Contract contract = contractRepository.findById(id).orElse(null);
        if(contract != null){
            contract.setHumanResourceManager(humanRestClient.findHumanResourceManager(contract.getHumanResourceManagerID()));
            contract.setEmployee(humanRestClient.findEmployee(contract.getEmployeeID()));
        }
        return contract;
    }

    @Override
    public List<Contract> findByEmployee(Long id) {
        List<Contract> contracts;
        contracts = contractRepository.findAll().stream().filter(contract -> contract.getEmployeeID().equals(id)).toList();
        contracts.forEach(contract -> {
            contract.setEmployee(humanRestClient.findEmployee(id));
            contract.setHumanResourceManager(humanRestClient.findHumanResourceManager(contract.getHumanResourceManagerID()));
        });
        return contracts;
    }

    @Override
    public List<Contract> findAll() {
        List<Contract> contracts = new ArrayList<>();
        contractRepository.findAll().forEach(contract -> {
            contract.setEmployee(humanRestClient.findEmployee(contract.getEmployeeID()));
            contract.setHumanResourceManager(humanRestClient.findHumanResourceManager(contract.getHumanResourceManagerID()));
            contracts.add(contract);
        });
        return contracts;
    }

    @Override
    public Map<String, Integer> getNumberOfDistinctContract() {
        Map<String,Integer> numberOfDistinctContract = new HashMap<>();
        int numberOfCDD = 0 , numberOfCDI = 0, numberOfAlternation = 0;
        numberOfDistinctContract.put("CDD",numberOfCDD);
        numberOfDistinctContract.put("CDI",numberOfCDI);
        numberOfDistinctContract.put("ALTERNANCE",numberOfAlternation);
        for (Contract contract : this.contractRepository.findAll()){
            if (contract.getType().equals(Type.CDD)){
                numberOfCDD++;
                numberOfDistinctContract.replace("CDD",numberOfCDD);
            }
            else if(contract.getType().equals(Type.CDI)){
                numberOfCDI++;
                numberOfDistinctContract.replace("CDI",numberOfCDI);
            }
            else{
                numberOfAlternation++;
                numberOfDistinctContract.replace("ALTERNANCE",numberOfAlternation);
            }
        }
        return numberOfDistinctContract;
    }

    @Override
    public float getAverageSalary() {
        float sumSalary = 0;
        int numberOfcontract = 0;
        for (Contract contract : contractRepository.findAll()){
            sumSalary+= contract.getRemuneration();
            numberOfcontract++;
        }
        return sumSalary/numberOfcontract;
    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
    }
}
