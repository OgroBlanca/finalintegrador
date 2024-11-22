package pe.edu.utp.service.facade;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.model.HorarioMedico;
import pe.edu.utp.service.HorarioMedicoService;

@Service
public class HorarioMedicoFacade {
    
    @Autowired
    private HorarioMedicoService horarioMedicoService;

    // Método para registrar un nuevo horario médico
    public HorarioMedico registrarHorarioMedico(HorarioMedico horarioMedico) {
        return horarioMedicoService.registrarHorarioMedico(horarioMedico);
    }

    // Método para obtener todos los horarios médicos
    public List<HorarioMedico> obtenerTodosHorariosMedicos() {
        return horarioMedicoService.obtenerTodosHorariosMedicos();
    }

    //Metodo para obtener todas las horas de un medico
    public HashMap<LocalDate,List<String>> obtenerHorasPorMedico(Integer id){
       return horarioMedicoService.obtenerHoras(id);
    }

    //Metodo para obtener horarios segun el medico
    public List<HorarioMedico> obtenerHorariosPorMedico(Integer idMedico){
         return horarioMedicoService.obtenerHorarioPorMedico(idMedico);
    }

    // Método para buscar un horario médico por ID
    public Optional<HorarioMedico> buscarHorarioMedicoPorId(Integer id) {
        return horarioMedicoService.buscarHorarioMedicoPorId(id);
    }

    // Método para actualizar un horario médico existente
    public HorarioMedico actualizarHorarioMedico(HorarioMedico horarioMedico) {
        return horarioMedicoService.actualizarHorarioMedico(horarioMedico);
    }

    // Método para eliminar un horario médico
    public void eliminarHorarioMedico(Integer id) {
        horarioMedicoService.eliminarHorarioMedico(id);
    }
}
