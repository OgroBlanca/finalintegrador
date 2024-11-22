package pe.edu.utp.service.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.model.Empleado;
import pe.edu.utp.service.EmpleadoService;

@Service
public class EmpleadoFacade {
    @Autowired
    private EmpleadoService service;

    // Método para registrar un nuevo empleado
    public Empleado registrarEmpleado(Empleado empleado) {
        return service.registrarEmpleado(empleado);
    }

    // Método para obtener todos los empleados
    public List<Empleado> obtenerTodosEmpleados() {
        return service.obtenerTodosEmpleados();
    }
    
    public Empleado buscarPorUsuario(int id){
        return service.buscarPorUsuario(id);
    }

    public List<Empleado> buscarPorNombre(String nombre){
        return service.buscarPorNombre(nombre);
    }


    // Método para buscar un empleado por ID
    public Empleado buscarEmpleadoPorId(Integer id) {
        return service.buscarEmpleadoPorId(id);
    }

    // Método para actualizar un empleado existente
    public Empleado actualizarEmpleado(Empleado empleado) {
        return service.actualizarEmpleado(empleado);
    }

    // Método para eliminar un empleado
    public void eliminarEmpleado(Integer id) {
        service.eliminarEmpleado(id);
    }
}
