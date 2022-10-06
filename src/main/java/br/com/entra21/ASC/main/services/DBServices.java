package br.com.entra21.ASC.main.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entra21.ASC.main.dtos.SchedulingDTO;
import br.com.entra21.ASC.main.model.Admin;
import br.com.entra21.ASC.main.model.Medical;
import br.com.entra21.ASC.main.model.Patient;
import br.com.entra21.ASC.main.model.Scheduling;
import br.com.entra21.ASC.main.model.TeamDados;
import br.com.entra21.ASC.main.model.ENUMS.PRIORITY;
import br.com.entra21.ASC.main.model.ENUMS.STATUS;
import br.com.entra21.ASC.main.model.ENUMS.Sex;
import br.com.entra21.ASC.main.repositories.AdminRepository;
import br.com.entra21.ASC.main.repositories.MedicalRepository;
import br.com.entra21.ASC.main.repositories.PatientRepository;
import br.com.entra21.ASC.main.repositories.SchedulingRepository;
import br.com.entra21.ASC.main.repositories.TeamRepository;

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
	@Autowired
	private TeamRepository teamRepository;
	
	public void instaciaDB() {
		Medical m1 = new Medical(null, "Cleber", "cleber1", "batata123", Sex.M, "075.491.584-01", "dasda@dasda.com", "(48)998475279", "batat silva", "295", "88780-000", "zimbabue", "souza'", "dolres'", "balser", "Clinico Geral");

		Patient p1 = new Patient(null, "Filipe", "batatinhaFrita123", "oieu souogoku", Sex.M, "043.288.354-16", "filipe.quickflip@gmail.com", "(48)998475279", "elza maria pereira pitigliani", "158", "88780-000", "Imbituba", "Santa Catarina","seu cleber","dona joana", "Diarreia");

		Scheduling s1 = new Scheduling(null, null, "batatinha frita", PRIORITY.HIGH, STATUS.OPEN, m1, p1);

		
		
		Scheduling s2 = new Scheduling(null, null, "cenouira frita", PRIORITY.HIGH, STATUS.OPEN, m1, p1);

//		Admin a1 = new Admin(null, "admin", "admin", "admin");
		
//		Admin a1 = new Admin(null, "ariana", "admin", "$2a$12$aZ11OqYnmuTNGdaKNBCIkei1obOsiy.CFz3SxqH4OXaoahueN8G6O");
		
		Admin a1 = new Admin(null, "teste", "admin", "admin");

		
		TeamDados filipe = new TeamDados("https://drive.google.com/file/d/1tm-8NTeO_7BDK0YEJ_qgXq5he6OO8UD2/view?usp=sharing", "Filipe Albuquerque", "https://github.com/Lipe-Albuquerque", "https://www.linkedin.com/in/filipe-albuquerque-9689891a5/", "https://lipe-albuquerque.github.io/");
		
		
		m1.getList().add(s1);
		p1.getList().add(s1);
		m1.getList().add(s2);

		medicalRepository.saveAll(Arrays.asList(m1));
		patientRepository.saveAll(Arrays.asList(p1));
		schedulingRepository.saveAll(Arrays.asList(s1));
		adminRepository.saveAll(Arrays.asList(a1));
	}
	
}
