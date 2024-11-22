package pe.edu.utp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.utp.model.Paciente;
import pe.edu.utp.repository.PacienteRepository;

@Service
@Transactional
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Método para registrar un nuevo paciente
    public Paciente registrarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Método para obtener todos los pacientes
    public List<Paciente> obtenerTodosPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarPorUsuario(int id){
        return pacienteRepository.findByUsuario_IdUsuario(id);
    }

    // Método para buscar un paciente por ID
    public Paciente buscarPacientePorId(Integer id) {
        return pacienteRepository.findById(id).orElseThrow( () -> new RuntimeException("no se encontro"));
    }

    // Método para actualizar un paciente existente
    public Paciente actualizarPaciente(Paciente paciente) {
        if (pacienteRepository.existsById(paciente.getIdPaciente())) {
            return pacienteRepository.save(paciente);
        }
        throw new RuntimeException("Paciente no encontrado");
    }

    // Método para eliminar un paciente
    public void eliminarPaciente(Integer id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Paciente no encontrado");
        }
    }
}