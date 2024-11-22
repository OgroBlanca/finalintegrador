package pe.edu.utp.service.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.model.Medico;
import pe.edu.utp.service.MedicoService;

@Service
public class MedicoFacade {

    @Autowired
    private MedicoService service;
    // Método para registrar un nuevo médico
    public Medico registrarMedico(Medico medico) {
        return service.registrarMedico(medico);
    }

    // Método para obtener todos los médicos
    public List<Medico> obtenerTodosMedicos() {
        return service.obtenerTodosMedicos();
    }

    //buscar medicos por nombre
    public List<Medico> buscarMedicos(String nombre) {
        return service.buscarMedicos(nombre);
    }

    public Medico buscarPorUsuario(int id){
        return service.buscarPorUsuario(id);
    }

    // Método para buscar un médico por ID
    public Medico buscarMedicoPorId(Integer id) {
        return service.buscarMedicoPorId(id);
    }

    // Método para actualizar un médico existente
    public Medico actualizarMedico(Medico medico) {
        return service.actualizarMedico(medico);
    }

    // Método para eliminar un médico
    public void eliminarMedico(Integer id) {
        service.eliminarMedico(id);
    }
}
