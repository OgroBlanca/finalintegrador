package pe.edu.utp.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.model.Usuario;
import pe.edu.utp.service.UsuarioService;

@Service
public class UsuarioFacade {
  
	@Autowired
	private UsuarioService service;
	
	public Usuario getUsuario(String correo) {
		return service.buscarPorCorreo(correo);
	}
	
	public void guardarUsuario(Usuario usuario) {
		service.saveUsuario(usuario);
	}

	public boolean verificarContraseña(String contraseña, String encrypt){
		return service.verificarContrasena(contraseña,encrypt);
	}
}
