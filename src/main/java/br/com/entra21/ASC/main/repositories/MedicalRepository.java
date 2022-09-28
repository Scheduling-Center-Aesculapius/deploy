package br.com.entra21.ASC.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.entra21.ASC.main.model.Medical;
@Repository
public interface MedicalRepository extends JpaRepository<Medical, Integer>{
	@Query("SELECT obj FROM Medical obj WHERE obj.cpf =:cpf")
	Medical findByCPF(@Param("cpf") String cpf);

}
