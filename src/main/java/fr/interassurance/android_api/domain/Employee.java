package fr.interassurance.android_api.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "employee")
public class Employee {

    @Id
    private String id;

    @Field("first_name")
    private String firstName;

    @Field("last_name")
    private String lastName;

    @Field("address")
    private Address address;

    @Field("mobile_number")
    private String mobileNumber;

    @Field("email")
    private String email;

    @Field("office_client")
    private OfficeClient officeClient;

    @Field("appointments")
    List<Appointment> appointments;
}
