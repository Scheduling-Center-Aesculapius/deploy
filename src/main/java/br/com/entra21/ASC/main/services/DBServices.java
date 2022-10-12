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
		Medical m1 = new Medical(null, "Peter Johnson", "peter.j", "medico1", Sex.M, "075.491.584-01",
				"peter@johnson.com", "(48)998475279", "Street 1", "295", "88780-000", "Bluemanau", "SC", "Pablo Johnson'",
				"Maya Johnson", "Dermatologist");
		Medical m2 = new Medical(null, "Melanie Johnson", "mel.j", "medica2", Sex.F, "897.292.530-64",
				"mel@johnson.com", "(48)998477979", "Street 2", "288", "88780-000", "Bluemanau", "SC", "Pablo Johnson'",
				"Maya Johnson", "Ophthalmologist");
		Medical m3 = new Medical(null, "Anthony Stark", "tony.stark", "medico3", Sex.M, "655.673.780-17",
				"tony@stark.com", "(48)998444270", "Street 3", "999", "88780-000", "Bluemanau", "SC", "Howard Stark'",
				"Maria Stark", "Neurologist");
		Medical m4 = new Medical(null, "Wanda Maximoff", "wanda.m", "medica4", Sex.F, "563.593.640-77",
				"wanda@maximoff.com", "(48)983375279", "Street 4", "33", "88780-000", "Bluemanau", "SC", "Pablo Maximoff'",
				"Maya Maximoff", "Psychologist");
		Medical m5 = new Medical(null, "Peter Parker", "peter.p", "medico5", Sex.M, "074.574.310-20",
				"peter@parker.com", "(48)999424265", "Street 5", "266", "88780-000", "Bluemanau", "SC", "Richard Parker",
				"Mary Parker", "Cardiologist");
		Medical m6 = new Medical(null, "Ozzy Osbourne", "ozzy.o", "medico6", Sex.M, "256.925.030-93",
				"ozzy@osbourne.com", "(48)989475279", "Street 6", "666", "88780-000", "Bluemanau", "SC", "Jack Osbourne'",
				"Lilian Osbourne", "Dentist");

		Patient p1 = new Patient(null, "Filipe", "batatinhaFrita123", "oieu souogoku", Sex.M, "043.288.354-16",
				"filipe.quickflip@gmail.com", "(48)998475279", "elza maria pereira pitigliani", "158", "88780-000",
				"Imbituba", "Santa Catarina", "seu cleber", "dona joana", "Diarreia");
		
		Patient p2 = new Patient(null, "Ariana", "sorvete", "chocolate", Sex.F, "099.164.089-63",
				"ariana@email.com", "(49)999424265", "Ozires Medeiros", "100", "89600-000",
				"Joaçaba", "Santa Catarina", "Luiz", "Jacinta", "Headache");

		Scheduling s1 = new Scheduling(null, null, "batatinha frita", PRIORITY.HIGH, STATUS.OPEN, m1, p1);

		Scheduling s2 = new Scheduling(null, null, "cenouira frita", PRIORITY.HIGH, STATUS.OPEN, m1, p1);

		Admin a1 = new Admin(null, "teste", "admin", "admin");
		

		TeamDados filipe = new TeamDados(null, "https://avatars.githubusercontent.com/Lipe-Albuquerque",
				"Filipe Albuquerque", "https://github.com/Lipe-Albuquerque",
				"https://www.linkedin.com/in/filipe-albuquerque-9689891a5/", "https://lipe-albuquerque.github.io/");

		TeamDados ariana = new TeamDados(null, "https://avatars.githubusercontent.com/ariana-ssilva", "Ariana Silva",
				"https://github.com/ariana-ssilva", "https://www.linkedin.com/in/ariana-moreira-691a86217/",
				"https://ariana-ssilva.github.io/");

		TeamDados thiago = new TeamDados(null, "https://avatars.githubusercontent.com/wzthiago", "Thiago Souza",
				"https://github.com/wzthiago", "https://www.linkedin.com/in/thiago-souza-53b03979/",
				"https://wzthiago.github.io/");

		m1.getList().add(s1);
		p1.getList().add(s1);
		m1.getList().add(s2);

		medicalRepository.saveAll(Arrays.asList(m1));
		medicalRepository.saveAll(Arrays.asList(m2));
		medicalRepository.saveAll(Arrays.asList(m3));
		medicalRepository.saveAll(Arrays.asList(m4));
		medicalRepository.saveAll(Arrays.asList(m5));
		medicalRepository.saveAll(Arrays.asList(m6));

		patientRepository.saveAll(Arrays.asList(p1));
		patientRepository.saveAll(Arrays.asList(p2));
		schedulingRepository.saveAll(Arrays.asList(s1));
		adminRepository.saveAll(Arrays.asList(a1));
		teamRepository.saveAll(Arrays.asList(filipe));
		teamRepository.saveAll(Arrays.asList(ariana));
		teamRepository.saveAll(Arrays.asList(thiago));
	}

}
