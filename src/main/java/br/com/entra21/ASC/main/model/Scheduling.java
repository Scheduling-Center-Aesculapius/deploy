package br.com.entra21.ASC.main.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.entra21.ASC.main.model.ENUMS.PRIORITY;
import br.com.entra21.ASC.main.model.ENUMS.STATUS;

@Entity
public class Scheduling implements Serializable {
	private static final long serialVersionUID = 1l;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dateOpen;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dateClosed;
	
	@NotEmpty(message = "Field requerid")
	private String description;
	private Integer priority;
	private Integer status;
	@ManyToOne // muitos pra um
	@JoinColumn(name = "medical_id")
	private Medical medical;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	public Scheduling() {
		super();
		this.setDateOpen(LocalDateTime.now()); // sempre que um agendamento for iniciado, ira receber a data e hora da
												// criação
		this.setPriority(PRIORITY.LOW); // por padrão será criada como prioridade baixa
		this.setStatus(STATUS.OPEN); // e se ela foi criada por padrão ela esta iniciada
	}

	public Scheduling(Integer id, LocalDateTime dataOpen, String description, PRIORITY priority, STATUS status, Medical medical,
			Patient patient) {
		super();
		this.id = id;
		this.dateOpen = dataOpen;
		this.description = description;
		this.priority = (priority == null) ? 0 : priority.getCod();
		this.status = (status == null) ? 0 : status.getCod();
		this.medical = medical;
		this.patient = patient;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateOpen() {
		return dateOpen;
	}

	public void setDateOpen(LocalDateTime dateOpen) {
		this.dateOpen = dateOpen;
	}

	public LocalDateTime getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(LocalDateTime dateClosed) {
		this.dateClosed = dateClosed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PRIORITY getPriority() {
		return PRIORITY.toEnum(this.priority);
	}

	public void setPriority(PRIORITY priority) {
		this.priority = priority.getCod();
	}

	public STATUS getStatus() {
		return STATUS.toEnum(status);
	}

	public void setStatus(STATUS status) {
		this.status = status.getCod();
	}

	public Medical getMedical() {
		return medical;
	}

	public void setMedical(Medical medical) {
		this.medical = medical;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scheduling other = (Scheduling) obj;
		return Objects.equals(id, other.id);
	}

}
