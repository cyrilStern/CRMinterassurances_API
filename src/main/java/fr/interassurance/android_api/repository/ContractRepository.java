package fr.interassurance.android_api.repository;


import fr.interassurance.android_api.domain.Contract;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends MongoRepository<Contract,String> {

    List<Contract> findAllByCommercialId(String commercial_id);
}
