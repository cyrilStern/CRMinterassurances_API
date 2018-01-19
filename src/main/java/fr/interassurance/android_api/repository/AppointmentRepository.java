package fr.interassurance.android_api.repository;


import fr.interassurance.android_api.domain.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment,String> {

    List<Appointment> findAllByEmployee_Id(String employeeId);

    List<Appointment> findAllByCommercialId(String commercialId);

    List<Appointment> findAllByAppointmentDateAndCommercialId(Date date, String commercial_Id);

    List<Appointment> findAllByAppointmentDateBeforeAndCommercialId(Date date, String commercial_Id);

    List<Appointment> findAllByAppointmentDateAfterAndCommercialId(Date date, String commercial_Id);

    List<Appointment> findAllByAppointmentDateBetweenAndCommercialId(Date startDate, Date endDate, String commercial_Id);

}
