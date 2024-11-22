package pe.edu.utp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.utp.model.Empleado;
import pe.edu.utp.repository.EmpleadoRepository;

@Service
@Transactional
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Método para registrar un nuevo empleado
    public Empleado registrarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    // Método para obtener todos los empleados
    public List<Empleado> obtenerTodosEmpleados() {
        return empleadoRepository.findAll();
    }
    
    public Empleado buscarPorUsuario(int id){
        return empleadoRepository.findByUsuario_IdUsuario(id);
    }

    public List<Empleado> buscarPorNombre(String nombre){
        return empleadoRepository.findByNombreContaining(nombre);
    }


    // Método para buscar un empleado por ID
    public Empleado buscarEmpleadoPorId(Integer id) {
        return empleadoRepository.findById(id).orElseThrow( () -> new RuntimeException("no se encontro"));
    }

    // Método para actualizar un empleado existente
    public Empleado actualizarEmpleado(Empleado empleado) {
        if (empleadoRepository.existsById(empleado.getIdEmpleado())) {
            return empleadoRepository.save(empleado);
        }
        throw new RuntimeException("Empleado no encontrado");
    }

    // Método para eliminar un empleado
    public void eliminarEmpleado(Integer id) {
        // System.out.println("Método eliminarEmpleado invocado con ID: " + id);
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
            System.out.println("Empleado eliminado con éxito");
        } else {
            System.out.println("Empleado tuvo problemas al eliminado");
            throw new RuntimeException("Empleado no encontrado");
        }
    }
}
