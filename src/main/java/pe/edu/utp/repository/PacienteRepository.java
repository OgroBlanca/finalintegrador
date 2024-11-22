package pe.edu.utp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Paciente findByUsuario_IdUsuario(Integer idUsuario);
}