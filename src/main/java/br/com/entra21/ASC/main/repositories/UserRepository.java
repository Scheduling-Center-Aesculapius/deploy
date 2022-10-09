package br.com.entra21.ASC.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.entra21.ASC.main.model.User;
@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("SELECT obj FROM user_ obj WHERE obj.cpf =:cpf")
	User findByCPF(@Param("cpf") String cpf);
	
	
	@Query(value = "select * from user_ where email = :email and password = :password", nativeQuery = true)
	public User loginRe(String email, String password);
	
}
