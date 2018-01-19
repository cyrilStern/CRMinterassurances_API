package fr.interassurance.android_api.repository;

import fr.interassurance.android_api.domain.OfficeClient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeClientRepository extends MongoRepository<OfficeClient,String> {

}
