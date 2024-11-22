package pe.edu.utp.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.edu.utp.model.Usuario;
import pe.edu.utp.repository.UsuarioRepository;



/**
 * CustomUserDetailsService
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		Usuario user = userRepository.findByCorreo(correo);
		String nombre = "";
		Integer idCargo = 0;
		if (user == null) {
			throw new UsernameNotFoundException("Usuario o contraseña no encontrada");
		}
		if (user.getEmpleado() != null) {
			nombre = user.getEmpleado().getNombre();
			idCargo = user.getEmpleado().getIdEmpleado();
		} else if(user.getPaciente() != null){
			nombre = user.getPaciente().getNombre();
			idCargo = user.getPaciente().getIdPaciente();
		} else {
            nombre = user.getMedico().getNombre();
			idCargo = user.getMedico().getIdMedico();
		}
		return new CustomUserDetails(nombre, user.getContrasena(), authorities(user),
				user.getCorreo(),idCargo);
	}

	private Collection<? extends GrantedAuthority> authorities(Usuario usuario) {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().getNombreRol().name().toUpperCase())); // Asegúrate de que esto sea coherente con tu lógica de

	}

}
