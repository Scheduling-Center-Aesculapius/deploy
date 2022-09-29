//package br.com.entra21.ASC.main.services;
//
//import java.util.Optional;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import br.com.entra21.ASC.main.data.AdminDetailData;
//import br.com.entra21.ASC.main.model.Admin;
//import br.com.entra21.ASC.main.repositories.AdminRepository;
//
//@Component
//public class UserDetailServiceImpl implements UserDetailsService{
//
//	private final AdminRepository repository;
//	
//	
//	
//	public UserDetailServiceImpl(AdminRepository repository) {
//		super();
//		this.repository = repository;
//	}
//
//
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<Admin> admin = Optional.of(repository.findByUsername(username));
//		
//		if(admin.isEmpty()) {
//			throw new UsernameNotFoundException("User [" + username + "] not found");
//		}
//		
//		return new AdminDetailData(admin);
//	}
//
//}
