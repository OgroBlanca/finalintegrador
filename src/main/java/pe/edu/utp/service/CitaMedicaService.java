package pe.edu.utp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.utp.model.CitaMedica;
import pe.edu.utp.model.CitaMedica.EstadoCita;
import pe.edu.utp.repository.CitaMedicaRepository;

@Service
@Transactional
public class CitaMedicaService {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    // Método para registrar una nueva cita médica
    public CitaMedica registrarCitaMedica(CitaMedica citaMedica) {
        return citaMedicaRepository.save(citaMedica);
    }

    // Método para obtener todas las citas médicas
    public List<CitaMedica> obtenerTodasCitasMedicas() {
        return citaMedicaRepository.findAll();
    }

    //Metodo para obtener todas las citas segun el paciente
    public List<CitaMedica> obtenerCitasPorPaciente(Integer idPaciente){
        return citaMedicaRepository.findByPaciente(idPaciente);
    }

    // Método para obtener todas las citas segun el medico y estado
    public List<CitaMedica> obtenerCitasPorMedicos(Integer id, EstadoCita estado) {
        return citaMedicaRepository.findByMedicoAndEstado(id,estado);
    }

    // Método para buscar una cita médica por ID
    public CitaMedica buscarCitaMedicaPorId(Integer id) {
        return citaMedicaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro"));
    }

    // Método para actualizar una cita médica existente
    public CitaMedica actualizarCitaMedica(CitaMedica citaMedica) {
        if (citaMedicaRepository.existsById(citaMedica.getIdCita())) {
            return citaMedicaRepository.save(citaMedica);
        }
        throw new RuntimeException("Cita médica no encontrada");
    }

    // Método para eliminar una cita médica
    public void eliminarCitaMedica(Integer id) {
        if (citaMedicaRepository.existsById(id)) {
            citaMedicaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cita médica no encontrada");
        }
    }

}
