package fr.interassurance.android_api.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;


@Data
@Document(collection = "appointment")
public class Appointment {

    @Id
    private String id;

    @Field("address")
    private Address address;

    @Field("appointment_date")
    private Date appointmentDate;

    @Field("employee")
    private Employee employee;

    @Field("commercialId")
    String commercialId;
}
