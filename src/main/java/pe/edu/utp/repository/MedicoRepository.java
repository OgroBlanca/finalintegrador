package pe.edu.utp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import pe.edu.utp.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    Medico findByUsuario_IdUsuario(Integer idUsuario);
    List<Medico> findByNombreContaining(String nombre);
}