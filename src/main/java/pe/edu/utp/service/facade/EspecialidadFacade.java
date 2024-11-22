package pe.edu.utp.service.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.model.Especialidad;
import pe.edu.utp.service.EspecialidadService;

@Service
public class EspecialidadFacade {
    @Autowired
    private EspecialidadService service;

    // Método para registrar una nueva especialidad
    public Especialidad registrarEspecialidad(Especialidad especialidad) {
        return service.registrarEspecialidad(especialidad);
    }

    // Método para obtener todas las especialidades
    public List<Especialidad> obtenerTodasEspecialidades() {
        return service.obtenerTodasEspecialidades();
    }

    // Método para buscar una especialidad por ID
    public Especialidad buscarEspecialidadPorId(Integer id) {
        return service.buscarEspecialidadPorId(id);
    }

    // Método para actualizar una especialidad existente
    public Especialidad actualizarEspecialidad(Especialidad especialidad) {
        return service.actualizarEspecialidad(especialidad);
    }

    // Método para eliminar una especialidad
    public void eliminarEspecialidad(Integer id) {
        service.eliminarEspecialidad(id);
    }
}
