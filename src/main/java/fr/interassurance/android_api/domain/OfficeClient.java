package fr.interassurance.android_api.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "office_client")
public class OfficeClient {

    @Id
    private String id;

    @Field("cabinet_name")
    private String cabinetName;

    @Field("address")
    private Address address;

    @Field("employees")
    private List<Employee> employees;

    @Field("commercials")
    List<Commercial> commercials;
}
