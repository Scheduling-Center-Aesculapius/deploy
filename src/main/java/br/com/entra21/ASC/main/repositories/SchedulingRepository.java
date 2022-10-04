package br.com.entra21.ASC.main.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.entra21.ASC.main.dtos.SchedulingDTO;
import br.com.entra21.ASC.main.model.Scheduling;

@Repository
@EnableJpaRepositories
public interface SchedulingRepository extends JpaRepository<Scheduling, Integer>{
	

	public List<SchedulingDTO> findByDateOpenBefore(LocalDateTime data);

}
