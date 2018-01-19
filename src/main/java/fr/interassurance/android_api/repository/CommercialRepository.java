package fr.interassurance.android_api.repository;

import fr.interassurance.android_api.domain.Commercial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the Commercial entity.
 */
@Repository
public interface CommercialRepository  extends MongoRepository<Commercial,String> {
}
