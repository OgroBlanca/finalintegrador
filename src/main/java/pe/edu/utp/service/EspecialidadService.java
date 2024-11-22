package pe.edu.utp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.utp.model.Especialidad;
import pe.edu.utp.repository.EspecialidadRepository;

@Service
@Transactional
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    // Método para registrar una nueva especialidad
    public Especialidad registrarEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    // Método para obtener todas las especialidades
    public List<Especialidad> obtenerTodasEspecialidades() {
        return especialidadRepository.findAll();
    }

    // Método para buscar una especialidad por ID
    public Especialidad buscarEspecialidadPorId(Integer id) {
        return especialidadRepository.findById(id).orElseThrow(() -> new RuntimeException("no se encontro la especialidad"));
    }

    // Método para actualizar una especialidad existente
    public Especialidad actualizarEspecialidad(Especialidad especialidad) {
        if (especialidadRepository.existsById(especialidad.getIdEspecialidad())) {
            return especialidadRepository.save(especialidad);
        }
        throw new RuntimeException("Especialidad no encontrada");
    }

    // Método para eliminar una especialidad
    public void eliminarEspecialidad(Integer id) {
        if (especialidadRepository.existsById(id)) {
            especialidadRepository.deleteById(id);
        } else {
            throw new RuntimeException("Especialidad no encontrada");
        }
    }
}