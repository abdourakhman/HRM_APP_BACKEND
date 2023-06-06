package ma.suptech.MSresource.services;


import ma.suptech.MSresource.client.HumanRestClient;
import ma.suptech.MSresource.models.Contract;
import ma.suptech.MSresource.repositories.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        contract.setEmployee(humanRestClient.findEmployee(contract.getEmployeeID()));
        return  contractRepository.save(contract);
    }

    @Override
    public Contract update(Contract contract) {
        contract.setEmployee(humanRestClient.findEmployee(contract.getEmployeeID()));
        return  contractRepository.save(contract);
    }

    @Override
    public Contract find(Long id) {
        Contract contract = contractRepository.findById(id).orElse(null);
        if(contract != null)
            contract.setEmployee(humanRestClient.findEmployee(contract.getEmployeeID()));
        return contract;
    }

    @Override
    public List<Contract> findByEmployee(Long id) {
        List<Contract> contracts;
        contracts = contractRepository.findAll().stream().filter(contract -> contract.getEmployeeID().equals(id)).toList();
        contracts.forEach(contract -> contract.setEmployee(humanRestClient.findEmployee(id)));
        return contracts;
    }

    @Override
    public List<Contract> findAll() {
        List<Contract> contracts = new ArrayList<>();
        contractRepository.findAll().forEach(contract -> {
            contract.setEmployee(humanRestClient.findEmployee(contract.getEmployeeID()));
            contracts.add(contract);
        });
        return contracts;
    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
    }
}
