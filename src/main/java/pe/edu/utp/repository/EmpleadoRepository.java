package pe.edu.utp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    Empleado findByUsuario_IdUsuario(Integer idUsuario);
    List<Empleado> findByNombreContaining(String nombre);
}