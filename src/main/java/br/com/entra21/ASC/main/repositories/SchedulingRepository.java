package br.com.entra21.ASC.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.entra21.ASC.main.model.Scheduling;
@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Integer>{

}
