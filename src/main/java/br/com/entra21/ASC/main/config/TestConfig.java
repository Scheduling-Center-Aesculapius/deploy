package br.com.entra21.ASC.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.entra21.ASC.main.services.DBServices;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBServices dbServices;
	
	@Bean  //SEMPRE QUE FOR CHAMADO A CLASSE TestConfig, ESSE MÉTODO VAI SER CHAMADO
	public void instanciaDB() {
		this.dbServices.instaciaDB(); //instanciado nosso banco
	}

}
