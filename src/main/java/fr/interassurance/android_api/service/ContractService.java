package fr.interassurance.android_api.service;

import fr.interassurance.android_api.domain.Contract;
import fr.interassurance.android_api.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Contract findOne(String id){
        return this.contractRepository.findOne(id);
    }

    public List<Contract> findAll(){
        return this.contractRepository.findAll();
    }

    public List<Contract> findAllByCommercial(String commercialId){
        return this.contractRepository.findAllByCommercialId(commercialId);
    }
}
