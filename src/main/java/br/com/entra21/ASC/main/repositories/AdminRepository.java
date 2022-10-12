package br.com.entra21.ASC.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.entra21.ASC.main.model.Admin;
import br.com.entra21.ASC.main.model.User;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query("SELECT obj FROM Admin obj WHERE obj.username =:username")
	Admin findByUsername(@Param("username") String username);
	
	@Query(value = "select * from admin where username = :username and password = :password", nativeQuery = true)
	public Admin loginAd(String username, String password);
}
