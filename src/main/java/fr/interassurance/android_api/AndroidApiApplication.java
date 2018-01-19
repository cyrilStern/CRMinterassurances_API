package fr.interassurance.android_api;

import fr.interassurance.android_api.domain.Address;
import fr.interassurance.android_api.domain.Appointment;
import fr.interassurance.android_api.domain.Commercial;
import fr.interassurance.android_api.domain.Contract;
import fr.interassurance.android_api.domain.Employee;
import fr.interassurance.android_api.domain.OfficeClient;
import fr.interassurance.android_api.domain.TypeContract;
import fr.interassurance.android_api.repository.AppointmentRepository;
import fr.interassurance.android_api.repository.CommercialRepository;
import fr.interassurance.android_api.repository.ContractRepository;
import fr.interassurance.android_api.repository.EmployeeRepository;
import fr.interassurance.android_api.repository.OfficeClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class AndroidApiApplication  implements CommandLineRunner {

	@Autowired private AppointmentRepository appointmentRepository;
	@Autowired private CommercialRepository commercialRepository;
	@Autowired private ContractRepository contractRepository;
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private OfficeClientRepository officeClientRepository;

	public static void main(String[] args) {
		SpringApplication.run(AndroidApiApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		//init();
	}

	public void init(){

		// 1 USER - Commercial
		Commercial gautier = new Commercial();
		gautier.setFirstName("Gautier");
		gautier.setLastName("Lehobey");
		gautier.setEmail("gautier.lehobey@interassurances.com");
		gautier.setMobileNumber("01020304");
		Address address = new Address();
		address.setAddressLine1("rue chapon");
		address.setCity("Paris");
		address.setPostalCode("75001");
		address.setCountry("France");
		gautier.setAddress(address);

		commercialRepository.save(gautier);

		// 2 USER - Commercial
		Commercial romain = new Commercial();
		romain.setFirstName("Romain");
		romain.setLastName("CAZAJOUS");
		romain.setEmail("romain.cazajous@interassurances.com");
		romain.setMobileNumber("01020304");
		Address address2 = new Address();
		address2.setAddressLine1("rue RIVOLI");
		address2.setCity("Paris");
		address2.setPostalCode("75002");
		address2.setCountry("France");
		romain.setAddress(address2);

		commercialRepository.save(romain);

		// 3 USER - Commercial
		Commercial catia = new Commercial();
		catia.setFirstName("Catia");
		catia.setLastName("Nunes");
		catia.setEmail("catia.nunes@interassurances.com");
		catia.setMobileNumber("01020304");
		Address address3 = new Address();
		address3.setAddressLine1("rue paris");
		address3.setCity("Paris");
		address3.setPostalCode("75012");
		address3.setCountry("France");
		catia.setAddress(address3);

		commercialRepository.save(catia);

		// 4 USER - Commercial
		Commercial mathieu = new Commercial();
		mathieu.setFirstName("Mathieu");
		mathieu.setLastName("RETIF");
		mathieu.setEmail("mathieu.retif@interassurances.com");
		mathieu.setMobileNumber("01020304");
		Address address4 = new Address();
		address4.setAddressLine1("rue de rome");
		address4.setCity("Paris");
		address4.setPostalCode("75015");
		address4.setCountry("France");
		mathieu.setAddress(address4);

		commercialRepository.save(mathieu);

		List<Commercial> commercials = commercialRepository.findAll();

		commercials.forEach( commercial -> {
			switch (commercial.getFirstName()){
				case "gautier":
					gautier.setId(commercial.getId());
				case "catia":
					catia.setId(commercial.getId());
				case "romain":
					romain.setId(commercial.getId());
				case "mathieu":
					mathieu.setId(commercial.getId());
			}
		});

		Contract contract_1 = new Contract();
		contract_1.setCommercialId(mathieu.getId());
		contract_1.setDateEffect(new Date());
		contract_1.setDateTermination(new Date());
		contract_1.setTypeContrat(TypeContract.GLI);

		contractRepository.save(contract_1);

		Contract contract_2 = new Contract();
		contract_2.setCommercialId(mathieu.getId());
		contract_2.setDateEffect(new Date());
		contract_2.setDateTermination(new Date());
		contract_2.setTypeContrat(TypeContract.GLICHERLOC);

		contractRepository.save(contract_2);

		Contract contract_3 = new Contract();
		contract_3.setCommercialId(catia.getId());
		contract_3.setDateEffect(new Date());
		contract_3.setDateTermination(new Date());
		contract_3.setTypeContrat(TypeContract.GLICHERLOC);

		contractRepository.save(contract_3);

		Contract contract_4 = new Contract();
		contract_4.setCommercialId(catia.getId());
		contract_4.setDateEffect(new Date());
		contract_4.setDateTermination(new Date());
		contract_4.setTypeContrat(TypeContract.GLICHERLOC);

		contractRepository.save(contract_4);

		Contract contract_5 = new Contract();
		contract_5.setCommercialId(catia.getId());
		contract_5.setDateEffect(new Date());
		contract_5.setDateTermination(new Date());
		contract_5.setTypeContrat(TypeContract.GLI);

		contractRepository.save(contract_5);

		Contract contract_6 = new Contract();
		contract_6.setCommercialId(gautier.getId());
		contract_6.setDateEffect(new Date());
		contract_6.setDateTermination(new Date());
		contract_6.setTypeContrat(TypeContract.GLI);

		contractRepository.save(contract_6);

		mathieu.setContracts(this.contractRepository.findAllByCommercialId(mathieu.getId()));
		catia.setContracts(this.contractRepository.findAllByCommercialId(catia.getId()));
		gautier.setContracts(this.contractRepository.findAllByCommercialId(gautier.getId()));

		Employee francesco = new Employee();
		francesco.setAddress(address);
		francesco.setFirstName("Francesco");
		francesco.setLastName("Esposito");
		francesco.setEmail("francesco.esposito@cabinet.com");
		francesco.setMobileNumber("111222");
		Appointment appointment_1 = new Appointment();
		appointment_1.setCommercialId(mathieu.getId());
		appointment_1.setAddress(address);
		appointment_1.setAppointmentDate(new Date());
		appointment_1.setEmployee(francesco);

		appointmentRepository.save(appointment_1);

		Employee cyril = new Employee();
		cyril.setAddress(address);
		cyril.setFirstName("Cyril");
		cyril.setLastName("Stern");
		cyril.setEmail("cyril.stern@cabinet.com");
		cyril.setMobileNumber("111222");
		Appointment appointment_2 = new Appointment();
		appointment_2.setCommercialId(mathieu.getId());
		appointment_2.setAddress(address);
		appointment_2.setAppointmentDate(new Date());
		appointment_2.setEmployee(cyril);

		appointmentRepository.save(appointment_2);

		Employee billy = new Employee();
		billy.setAddress(address);
		billy.setFirstName("Billy");
		billy.setLastName("Drai");
		billy.setEmail("billy.drai@cabinet.com");
		billy.setMobileNumber("111222");
		Appointment appointment_3 = new Appointment();
		appointment_3.setCommercialId(mathieu.getId());
		appointment_3.setAddress(address2);
		appointment_3.setAppointmentDate(new Date());
		appointment_3.setEmployee(billy);

		appointmentRepository.save(appointment_3);

		francesco = employeeRepository.save(francesco);
		cyril = employeeRepository.save(cyril);
		billy = employeeRepository.save(billy);

		Appointment appointment_4 = new Appointment();
		appointment_4.setCommercialId(catia.getId());
		appointment_4.setAddress(address2);
		appointment_4.setAppointmentDate(new Date());
		appointment_4.setEmployee(billy);

		appointmentRepository.save(appointment_4);

		Appointment appointment_5 = new Appointment();
		appointment_5.setCommercialId(catia.getId());
		appointment_5.setAddress(address3);
		appointment_5.setAppointmentDate(new Date());
		appointment_5.setEmployee(billy);

		appointmentRepository.save(appointment_5);

		Appointment appointment_6 = new Appointment();
		appointment_6.setCommercialId(gautier.getId());
		appointment_6.setAddress(address3);
		appointment_6.setAppointmentDate(new Date());
		appointment_6.setEmployee(francesco);

		appointmentRepository.save(appointment_6);

		Appointment appointment_7 = new Appointment();
		appointment_7.setCommercialId(gautier.getId());
		appointment_7.setAddress(address4);
		appointment_7.setAppointmentDate(new Date());
		appointment_7.setEmployee(cyril);

		appointmentRepository.save(appointment_7);

		mathieu.setAppointments(appointmentRepository.findAllByCommercialId(mathieu.getId()));
		catia.setAppointments(appointmentRepository.findAllByCommercialId(catia.getId()));
		gautier.setAppointments(appointmentRepository.findAllByCommercialId(gautier.getId()));


		OfficeClient officeClient_1 = new OfficeClient();
		officeClient_1.setCabinetName("assurcopro");
		officeClient_1.setAddress(address);
		officeClient_1.setCommercials(new ArrayList<Commercial>(){{add(catia);}});
		List<Employee> employeesAssurcoPRo = new ArrayList<>();
		employeesAssurcoPRo.add(francesco);
		officeClient_1.setEmployees(employeesAssurcoPRo);
		officeClientRepository.save(officeClient_1);

		OfficeClient officeClient_2 = new OfficeClient();
		officeClient_2.setCabinetName("belair");
		officeClient_2.setAddress(address2);
		officeClient_2.setCommercials(new ArrayList<Commercial>(){{add(mathieu);}});
		List<Employee> employeesbelair = new ArrayList<>();
		employeesbelair.add(cyril);
		officeClient_2.setEmployees(employeesbelair);
		officeClientRepository.save(officeClient_2);

		OfficeClient officeClient_3 = new OfficeClient();
		officeClient_3.setCabinetName("interassurance");
		officeClient_3.setCommercials(new ArrayList<Commercial>(){{add(gautier);add(romain);}});
		List<Employee> employeesinterassurance = new ArrayList<>();
		employeesinterassurance.add(billy);
		officeClient_3.setEmployees(employeesinterassurance);
		officeClientRepository.save(officeClient_3);

		commercialRepository.save(mathieu);
		commercialRepository.save(gautier);
		commercialRepository.save(romain);
		commercialRepository.save(catia);

	}
}
