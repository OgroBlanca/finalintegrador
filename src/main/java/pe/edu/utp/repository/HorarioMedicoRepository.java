package pe.edu.utp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.utp.model.HorarioMedico;

@Repository
public interface HorarioMedicoRepository extends JpaRepository<HorarioMedico, Integer> {
   // Método para obtener los horarios de un médico por su ID
   @Query("SELECT h FROM HorarioMedico h WHERE h.medico.idMedico = :idMedico")
   List<HorarioMedico> findByMedico(@Param("idMedico") Integer idMedico);
   
}