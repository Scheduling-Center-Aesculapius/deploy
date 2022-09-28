package br.com.entra21.ASC.main.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.entra21.ASC.main.data.AdminDetailData;
import br.com.entra21.ASC.main.model.Admin;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	public static final int TOKEN_EXPIRED = 600_000; // 10 MINUTES
	public static final String TOKEN_PASSWORD = "826b54cb-88ad-431f-bcd3-5b90c8630682";

	private final AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationmanager) {
		this.authenticationManager = authenticationmanager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {
			Admin admin = new ObjectMapper().readValue(request.getInputStream(), Admin.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(admin.getUsername(),
					admin.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException("Authentication failed!", e);
		}

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		AdminDetailData adminData = (AdminDetailData) authResult.getPrincipal();

		// criação do jwt
		String token = JWT.create().withSubject(adminData.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRED)) // SOMA OS MILISSEGUNDOS ATUAIS
																						// MAIS A CONSTANTE
				.sign(Algorithm.HMAC512(TOKEN_PASSWORD)); // ASSINATURA DE TOKEN COM UMA SENHA, GERADA PELO GUIDGENEATOR
		response.getWriter().write(token);
		response.getWriter().flush();
	}

}
