package fr.interassurance.android_api.service;

import fr.interassurance.android_api.domain.Commercial;
import fr.interassurance.android_api.repository.CommercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommercialService {

    private final CommercialRepository commercialRepository;

    @Autowired
    public CommercialService(CommercialRepository commercialRepository) {
        this.commercialRepository = commercialRepository;
    }

    public Commercial findOne(String id){
        return this.commercialRepository.findOne(id);
    }

    public void delete(String id){
        this.commercialRepository.delete(id);
    }
}
