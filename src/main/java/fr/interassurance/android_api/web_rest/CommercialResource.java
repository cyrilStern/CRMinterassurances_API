package fr.interassurance.android_api.web_rest;

import fr.interassurance.android_api.domain.Commercial;
import fr.interassurance.android_api.service.CommercialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/commercial")
public class CommercialResource {

    private final Logger log = LoggerFactory.getLogger(CommercialResource.class);

    private static final String ENTITY_NAME = "commercial";

    private final CommercialService commercialService;

    @Autowired
    public CommercialResource(CommercialService commercialService){
        this.commercialService=commercialService;
    }

    /**
     * GET  /commercial/:id : get the "id" commercial.
     *
     * @param id the id of the commercial to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the participant, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public Commercial getCommercial(@PathVariable String id) {
        return commercialService.findOne(id);
    }

    /**
     * DELETE  /commercial/:id : delete the "id" commercial.
     *
     * @param id the id of the commercial to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/{id}")
    public void deleteCommercial(@PathVariable String id) {
        commercialService.delete(id);
    }
}
