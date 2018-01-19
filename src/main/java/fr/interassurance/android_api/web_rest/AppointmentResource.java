package fr.interassurance.android_api.web_rest;


import fr.interassurance.android_api.domain.Appointment;
import fr.interassurance.android_api.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentResource {

    private final Logger log = LoggerFactory.getLogger(AppointmentResource.class);

    private static final String ENTITY_NAME = "appointment";

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentResource(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    /**
     * GET get a list of appointments by employee_id
     * @param employeeId Employee Id
     * @return appointments list
     */
    @GetMapping("/employee/{employeeId}")
    public List<Appointment> findAllByEmployeeId(@PathVariable String employeeId){
        return this.appointmentService.findAppointmentsByEmployee(employeeId);
    }

    @GetMapping("/all")
    public List<Appointment> findAll(){
        return this.appointmentService.findAll();
    }

    /**
     * GET get a list of appointments by commercial_id
     * @param commercialId Commercial Id
     * @return appointments list
     */
    @GetMapping("/commercial/{commercialId}")
    public List<Appointment> findAllByCommercialId(@PathVariable String commercialId){
        return this.appointmentService.findAppointmentsByCommercial(commercialId);
    }

    /**
     * GET get a list of appointments by a date made by a commercial
     * @param date appointment date
     * @param commercial_Id commercial id
     * @return appointments list
     */
    @GetMapping
    public List<Appointment> findAllByAppointmentDateAndCommercialId(@RequestParam Date date, @RequestParam String commercial_Id){
        return this.appointmentService.findAppointmentsByAppointmentDateAndCommercial(date,commercial_Id);
    }

    /**
     * GET get a list of appointments before a date made by a commercial
     * @param date appointment date
     * @param commercial_Id commercial id
     * @return appointments list
     */
    @GetMapping("/before")
    public List<Appointment> findAllByAppointmentDateBeforeAndCommercialId(@RequestParam Date date,@RequestParam String commercial_Id){
        return this.appointmentService.findAppointmentsByAppointmentDateBeforeAndCommercial(date,commercial_Id);
    }

    /**
     * GET get a list of appointments after a date made by a commercial
     * @param date appointment date
     * @param commercial_Id commercial id
     * @return appointments list
     */
    @GetMapping("/after")
    public List<Appointment> findAllByAppointmentDateAfterAndCommercialId(@RequestParam Date date,@RequestParam String commercial_Id){
        return this.appointmentService.findAppointmentsByDateAfterAndCommercial(date,commercial_Id);
    }

    /**
     * GET get a list of appointments between two dates made by a commercial
     * @param startDate start date
     * @param endDate end date
     * @param commercial_Id commercial id
     * @return appointments list
     */
    @GetMapping("/between")
    public List<Appointment> findAllByAppointmentDateBetweenAndCommercialId(@RequestParam Date startDate,@RequestParam Date endDate,@RequestParam String commercial_Id){
        return this.appointmentService.findAppointmentsByDateBetweenAndCommercial(startDate, endDate, commercial_Id);
    }
}
