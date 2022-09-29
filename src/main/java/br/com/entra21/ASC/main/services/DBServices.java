package br.com.entra21.ASC.main.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entra21.ASC.main.model.Admin;
import br.com.entra21.ASC.main.model.Medical;
import br.com.entra21.ASC.main.model.Patient;
import br.com.entra21.ASC.main.model.Scheduling;
import br.com.entra21.ASC.main.model.ENUMS.PRIORITY;
import br.com.entra21.ASC.main.model.ENUMS.STATUS;
import br.com.entra21.ASC.main.model.ENUMS.Sex;
import br.com.entra21.ASC.main.repositories.AdminRepository;
import br.com.entra21.ASC.main.repositories.MedicalRepository;
import br.com.entra21.ASC.main.repositories.PatientRepository;
import br.com.entra21.ASC.main.repositories.SchedulingRepository;

@Service
public class DBServices {
	@Autowired
	private MedicalRepository medicalRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private SchedulingRepository schedulingRepository;
	@Autowired
	private AdminRepository adminRepository;
	
	public void instaciaDB() {
		Medical m1 = new Medical(null, "Dr.Sthranger", "dsr666", "Ariasana1@", Sex.M, "07549158401",
				"dr.estrnho@yahoo.com", "48998475279", "hercilio nunes", "295", "88780000", "blumnau", "Santa catarina",
				"Cardiologista");
		
		Medical m2 = new Medical(null, "Dr.cleber", "clebinho66", "salamaleico@", Sex.O, "043.288.354-16",
				"dr.clebinho@gmail.com", "4798541272", "albert silva", "12", "57852100", "ilhota", "rio grande do sul",
				"Dentista");

		Patient p1 = new Patient(null, "Filipe", "batatinhaFrita123", "oieu souogoku", Sex.M, "04328835416", "filipe.quickflip@gmail.com", "48998475279", "elza maria pereira pitigliani", "158", "88780-000", "Imbituba", "Santa Catarina", "Diarreia");

		Scheduling s1 = new Scheduling(null, "batatinha frita", PRIORITY.HIGH, STATUS.OPEN, m1, p1);

//		Admin a1 = new Admin(null, "admin", "admin", "admin");
		
//		Admin a1 = new Admin(null, "ariana", "admin", "$2a$12$aZ11OqYnmuTNGdaKNBCIkei1obOsiy.CFz3SxqH4OXaoahueN8G6O");
		
		Admin a1 = new Admin(null, "teste", "teste", "teste");

		m1.getList().add(s1);
		p1.getList().add(s1);
		

		medicalRepository.saveAll(Arrays.asList(m1, m2));
		patientRepository.saveAll(Arrays.asList(p1));
		schedulingRepository.saveAll(Arrays.asList(s1));
		adminRepository.saveAll(Arrays.asList(a1));
	}
	
}
