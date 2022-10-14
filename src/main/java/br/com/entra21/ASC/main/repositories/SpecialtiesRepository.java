package br.com.entra21.ASC.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.entra21.ASC.main.model.Admin;
import br.com.entra21.ASC.main.model.Specialties;
import br.com.entra21.ASC.main.model.TeamDados;

@Repository
@EnableJpaRepositories
public interface SpecialtiesRepository extends JpaRepository<Specialties, String> {
	@Query("SELECT obj FROM Specialties obj WHERE obj.name =:name")
	Specialties findByName(@Param("name") String name);
}
