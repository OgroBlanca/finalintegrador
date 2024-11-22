package pe.edu.utp.service.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.model.Paciente;
import pe.edu.utp.service.PacienteService;

@Service
public class PacienteFacade {
      @Autowired
        private PacienteService service;
    
        // Método para registrar un nuevo paciente
        public Paciente registrarPaciente(Paciente paciente) {
            return service.registrarPaciente(paciente);
        }
    
        // Método para obtener todos los pacientes
        public List<Paciente> obtenerTodosPacientes() {
            return service.obtenerTodosPacientes();
        }
    
        // Método para buscar un paciente por ID
        public Paciente buscarPacientePorId(Integer id) {
            return service.buscarPacientePorId(id);
        }

        public Paciente buscarPorUsuario(int id){
            return service.buscarPorUsuario(id);
        }
    
        // Método para actualizar un paciente existente
        public Paciente actualizarPaciente(Paciente paciente) {
           return service.actualizarPaciente(paciente);
        }
    
        // Método para eliminar un paciente
        public void eliminarPaciente(Integer id) {
            service.eliminarPaciente(id);
        }

}
