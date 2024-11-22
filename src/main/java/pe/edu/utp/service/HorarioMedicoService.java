package pe.edu.utp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.utp.model.CitaMedica;
import pe.edu.utp.model.HorarioMedico;
import pe.edu.utp.model.CitaMedica.EstadoCita;
import pe.edu.utp.repository.CitaMedicaRepository;
import pe.edu.utp.repository.HorarioMedicoRepository;

@Service
@Transactional
public class HorarioMedicoService {

    @Autowired
    private HorarioMedicoRepository horarioMedicoRepository;
    @Autowired
    private CitaMedicaService citaService;

    public HashMap<LocalDate, List<String>> obtenerHoras(Integer id) {
        // Recuperar todos los horarios médicos desde la base de datos
        List<HorarioMedico> horarios = horarioMedicoRepository.findAll();
        List<CitaMedica> citas = citaService.obtenerCitasPorMedicos(id, EstadoCita.EN_ESPERA);
    
        // Crear el HashMap para almacenar la fecha como clave y la lista de horas como valor
        HashMap<LocalDate, List<String>> horariosMap = new HashMap<>();
        // Formato sin segundos
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    
        // Recorrer cada horario médico
        for (HorarioMedico horario : horarios) {
            LocalDate fecha = horario.getFecha();
            LocalTime horaInicio = horario.getHoraInicio();
            LocalTime horaFin = horario.getHoraFin();
    
            // Generar las horas entre horaInicio y horaFin
            List<String> horas = new ArrayList<>();
            LocalTime currentTime = horaInicio;
    
            while (!currentTime.isAfter(horaFin)) {
                // Verificar que no haya citas para esa fecha y hora
                boolean horaDisponible = true;
                for (CitaMedica cita : citas) {
                    if (fecha.equals(cita.getFecha()) && currentTime.equals(cita.getHora())) {
                        horaDisponible = false;
                        break;
                    }
                }
    
                // Si la hora está disponible, agregarla a la lista
                if (horaDisponible) {
                    horas.add(currentTime.format(formatter));
                }
    
                // Avanzar al siguiente intervalo de tiempo (por ejemplo, cada 30 minutos)
                currentTime = currentTime.plusMinutes(30); // Ajusta el intervalo de tiempo según lo necesites
            }
    
            // Agregar la fecha y la lista de horas al HashMap
            horariosMap.put(fecha, horas);
        }
    
        return horariosMap;
    }

    // Método para registrar un nuevo horario médico
    public HorarioMedico registrarHorarioMedico(HorarioMedico horarioMedico) {
        return horarioMedicoRepository.save(horarioMedico);
    }

    // Método para obtener todos los horarios médicos
    public List<HorarioMedico> obtenerTodosHorariosMedicos() {
        return horarioMedicoRepository.findAll();
    }

    // Metodo para obtener los horarios segun el medico
    public List<HorarioMedico> obtenerHorarioPorMedico(Integer idMedico) {
        return horarioMedicoRepository.findByMedico(idMedico);
    }

    // Método para buscar un horario médico por ID
    public Optional<HorarioMedico> buscarHorarioMedicoPorId(Integer id) {
        return horarioMedicoRepository.findById(id);
    }

    // Método para actualizar un horario médico existente
    public HorarioMedico actualizarHorarioMedico(HorarioMedico horarioMedico) {
        if (horarioMedicoRepository.existsById(horarioMedico.getIdHorario())) {
            return horarioMedicoRepository.save(horarioMedico);
        }
        throw new RuntimeException("Horario médico no encontrado");
    }

    // Método para eliminar un horario médico
    public void eliminarHorarioMedico(Integer id) {
        if (horarioMedicoRepository.existsById(id)) {
            horarioMedicoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Horario médico no encontrado");
        }
    }
}