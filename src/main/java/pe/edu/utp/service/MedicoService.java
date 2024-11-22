package pe.edu.utp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.utp.model.Medico;
import pe.edu.utp.repository.MedicoRepository;

@Service
@Transactional
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    // Método para registrar un nuevo médico
    public Medico registrarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    // Método para obtener todos los médicos
    public List<Medico> obtenerTodosMedicos() {
        return medicoRepository.findAll();
    }
    //buscar medicos por nombre
    public List<Medico> buscarMedicos(String nombre) {
        return medicoRepository.findByNombreContaining(nombre);
    }

    public Medico buscarPorUsuario(int id){
        return medicoRepository.findByUsuario_IdUsuario(id);
    }

    // Método para buscar un médico por ID
    public Medico buscarMedicoPorId(Integer id) {
        return medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("no se encontro medico"));
    }

    // Método para actualizar un médico existente
    public Medico actualizarMedico(Medico medico) {
        if (medicoRepository.existsById(medico.getIdMedico())) {
            return medicoRepository.save(medico);
        }
        throw new RuntimeException("Médico no encontrado");
    }

    // Método para eliminar un médico
    public void eliminarMedico(Integer id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Médico no encontrado");
        }
    }
}