package br.com.entra21.ASC.main.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) // gestão do controle de acessos

public class JWTConfiguration  {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
        .httpBasic()
        .and()
        .authorizeHttpRequests()
        .anyRequest().authenticated()
        .and()
        .csrf().disable();
		
		return http.build();
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
//	 private final UserDetailServiceImpl userService;
//	    private final PasswordEncoder passwordEncoder;
//
//	    public JWTConfiguration(UserDetailServiceImpl userService, PasswordEncoder passwordEncoder) {
//	        this.userService = userService;
//	        this.passwordEncoder = passwordEncoder;
//	    }
//
//	    @Override
//	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
//	    }
//
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http.csrf().disable().authorizeRequests()
//	                .antMatchers(HttpMethod.POST, "/login").permitAll()
//	                .anyRequest().authenticated()
//	                .and()
//	                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//	                .addFilter(new JWTValidateFilter(authenticationManager()))
//	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	    }
//
//	    @Bean
//	    CorsConfigurationSource corsConfigurationSource() {
//	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//	        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
//	        source.registerCorsConfiguration("/**", corsConfiguration);
//	        return source;
//	    }
	    
	
}
