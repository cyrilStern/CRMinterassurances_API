package fr.interassurance.android_api.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Accessors(chain = true)
public class Address {

    @Field("company_name")
    private String companyName;

    @Field("addressLine1")
    private String addressLine1;

    @Field("city")
    private String city;

    @Field("postalCode")
    private String postalCode;

    @Field("country")
    private String country;
}
