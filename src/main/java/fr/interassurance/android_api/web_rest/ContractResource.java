package fr.interassurance.android_api.web_rest;


import fr.interassurance.android_api.domain.Contract;
import fr.interassurance.android_api.service.ContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/contract")
public class ContractResource {

    private final Logger log = LoggerFactory.getLogger(ContractResource.class);

    private static final String ENTITY_NAME = "contract";

    private final ContractService contractService;

    @Autowired
    public ContractResource(ContractService contractService){
        this.contractService = contractService;
    }

    /**
     * GET get a list of contracts managed by a commercial
     * @param commercial_Id commercial id
     * @return contracts list
     */
    @GetMapping
    public List<Contract> findAllContractsByCommercial_Id(@RequestParam String commercial_Id){
        return this.contractService.findAllByCommercial(commercial_Id);
    }
}
