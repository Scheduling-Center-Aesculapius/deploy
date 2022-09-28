package br.com.entra21.ASC.main.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.entra21.ASC.main.model.Admin;

public class AdminDetailData implements UserDetails{

	private static final long serialVersionUID = -3587803766979701382L;
	private final Optional<Admin> admin;
	
	public AdminDetailData(Optional<Admin> admin) {
		this.admin = admin;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return admin.orElse(new Admin()).getPassword();
	}

	@Override
	public String getUsername() {
		return admin.orElse(new Admin()).getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
