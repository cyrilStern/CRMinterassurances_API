package fr.interassurance.android_api.service;

import fr.interassurance.android_api.domain.Appointment;
import fr.interassurance.android_api.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    /**
     * Find one commercial by his id
     * @param id
     * @return
     */
    public Appointment findOne(String id){
        return this.appointmentRepository.findOne(id);
    }

    /**
     * Find all the commercials
     * @return
     */
    public List<Appointment> findAll(){
        return this.appointmentRepository.findAll();
    }

    /**
     * Find an appointments list made by an employee
     * @param employeeId
     * @return
     */
    public List<Appointment> findAppointmentsByEmployee (String employeeId){
        return this.appointmentRepository.findAllByEmployee_Id(employeeId);
    }

    /**
     * Find an appointments list made by a commercial
     * @param commercialId
     * @return
     */
    public List<Appointment> findAppointmentsByCommercial (String commercialId){
        return this.appointmentRepository.findAllByCommercialId(commercialId);
    }

    /**
     * Find an appointments list made by a commercial
     * @param date
     * @return
     */
    public List<Appointment> findAppointmentsByAppointmentDateAndCommercial (Date date, String commercial_Id){
        return this.appointmentRepository.findAllByAppointmentDateAndCommercialId(date,commercial_Id);
    }

    /**
     *
     * @param date
     * @return
     */
    public List<Appointment> findAppointmentsByAppointmentDateBeforeAndCommercial (Date date, String commercial_Id){
        return this.appointmentRepository.findAllByAppointmentDateBeforeAndCommercialId(date,commercial_Id);
    }

    /**
     *
     * @param date
     * @return
     */
    public List<Appointment> findAppointmentsByDateAfterAndCommercial (Date date, String commercial_Id){
        return this.appointmentRepository.findAllByAppointmentDateAfterAndCommercialId(date,commercial_Id);
    }

    /**
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public List<Appointment> findAppointmentsByDateBetweenAndCommercial (Date startDate,Date endDate, String commercial_Id){
        return this.appointmentRepository.findAllByAppointmentDateBetweenAndCommercialId(startDate,endDate,commercial_Id);
    }
}
