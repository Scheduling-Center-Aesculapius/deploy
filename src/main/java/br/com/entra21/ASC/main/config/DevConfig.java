package br.com.entra21.ASC.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.entra21.ASC.main.services.DBServices;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBServices dbServices;
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;

	@Bean // SEMPRE QUE FOR CHAMADO A CLASSE TestConfig, ESSE MÉTODO VAI SER CHAMADO
	public boolean instanciaDB() {

		if (ddl.equals("create")) {
			this.dbServices.instaciaDB(); // instanciado nosso banco
		}

		return false;

	}

}
