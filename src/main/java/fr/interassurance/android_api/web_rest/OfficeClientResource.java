package fr.interassurance.android_api.web_rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/office_client")
public class OfficeClientResource {

    private final Logger log = LoggerFactory.getLogger(OfficeClientResource.class);

    private static final String ENTITY_NAME = "office_client";
}
