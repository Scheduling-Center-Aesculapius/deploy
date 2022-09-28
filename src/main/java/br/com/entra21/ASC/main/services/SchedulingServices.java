package br.com.entra21.ASC.main.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entra21.ASC.main.dtos.SchedulingDTO;
import br.com.entra21.ASC.main.model.Medical;
import br.com.entra21.ASC.main.model.Patient;
import br.com.entra21.ASC.main.model.Scheduling;
import br.com.entra21.ASC.main.model.ENUMS.PRIORITY;
import br.com.entra21.ASC.main.model.ENUMS.STATUS;
import br.com.entra21.ASC.main.repositories.SchedulingRepository;
import br.com.entra21.ASC.main.services.exception.ObjectNotFoundException;

@Service
public class SchedulingServices {

	@Autowired
	private SchedulingRepository repositori;

	@Autowired
	private MedicalService serviceMedical;

	@Autowired
	private PatientService servicePatient;

	public Scheduling findById(Integer id) {
		Optional<Scheduling> obj = repositori.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Scheduling.class.getName()));
	}

	public List<Scheduling> findAll() {
		return repositori.findAll();
	}

	public Scheduling create(@Valid SchedulingDTO obj) {

		return fromDTO(obj);
	}

	public Scheduling update(@Valid SchedulingDTO obj) {
		
		findById(obj.getId());
		return fromDTO(obj);
	}

	
	private Scheduling fromDTO(SchedulingDTO obj) {

		Scheduling newObj = new Scheduling();
		newObj.setId(obj.getId());
		newObj.setDescription(obj.getDescription());

		newObj.setPriority(PRIORITY.toEnum(obj.getPriority()));
		newObj.setStatus(STATUS.toEnum(obj.getStatus()));

		Medical med = serviceMedical.findById(obj.getMedical());
		Patient pat = servicePatient.findById(obj.getPatient());

		newObj.setMedical(med);
		newObj.setPatient(pat);
		
		if(newObj.getStatus().getCod().equals(2)) {
			newObj.setDateClosed(LocalDateTime.now());
		}
		
		return repositori.save(newObj);
	}

	
}
