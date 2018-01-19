package fr.interassurance.android_api.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Data
@Document(collection = "commercial")
public class Commercial implements Serializable {

    @Id
    private String id;

    @Field("firstName")
    private String firstName;

    @Field("lastName")
    private String lastName;

    @Field("address")
    private Address address;

    @Field("mobileNumber")
    private String mobileNumber;

    @Field("email")
    private String email;

    @Field("cabinets_clients")
    List<OfficeClient> officeClients;

    @Field("appointments")
    List<Appointment> appointments;

    @Field("contracts")
    List<Contract> contracts;
}