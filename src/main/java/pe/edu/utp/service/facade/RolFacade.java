package pe.edu.utp.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.model.Rol;
import pe.edu.utp.model.Rol.RolEnum;
import pe.edu.utp.service.RolService;

@Service
public class RolFacade {
    
    @Autowired
    private RolService service;

    public Rol getRol(RolEnum nombre){
        return service.buscarRoLPorNombre(nombre);
    }

    public Rol findById(int id){
        return service.buscarRolPorId(id);
    }
}
