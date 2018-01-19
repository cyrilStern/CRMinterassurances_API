package fr.interassurance.android_api.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "contract")
public class Contract {

    @Id
    private String id;

    @Field("date_effect")
    Date dateEffect;

    @Field("date_termination")
    Date dateTermination;

    @Field("type_contract")
    TypeContract typeContrat;

    @Field("commercialId")
    String commercialId;
}
