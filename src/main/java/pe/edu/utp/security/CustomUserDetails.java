package pe.edu.utp.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
    private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	private String correo;
	private Integer idCargo;
	
	
	public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
			String correo, Integer idCargo) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.correo = correo;
		this.idCargo = idCargo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public String getCorreo() {
		return correo;
	}

	public Integer getIdCargo() {
		return idCargo;
	}
}
