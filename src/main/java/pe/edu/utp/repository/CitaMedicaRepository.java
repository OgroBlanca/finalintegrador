package pe.edu.utp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.utp.model.CitaMedica;
import pe.edu.utp.model.CitaMedica.EstadoCita;

@Repository
public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Integer> {
    // Métodos personalizados pueden ir aquí
    @Query("SELECT c FROM CitaMedica c WHERE c.medico.idMedico = :idMedico AND c.estado = :estado")
List<CitaMedica> findByMedicoAndEstado(Integer idMedico, EstadoCita estado);
}