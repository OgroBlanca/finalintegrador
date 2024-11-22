package pe.edu.utp.controller.rest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import pe.edu.utp.model.HorarioMedico;
import pe.edu.utp.model.Medico;
import pe.edu.utp.security.CustomUserDetails;
import pe.edu.utp.service.HorarioMedicoService;
import pe.edu.utp.service.facade.HorarioMedicoFacade;
import pe.edu.utp.service.facade.MedicoFacade;

@RestController
@RequestMapping("/api/v1/horario")
public class HorarioMedicoApiController {
    
    @Autowired
    HorarioMedicoFacade horarioFacade;
    @Autowired
    MedicoFacade medicoFacade;
    
    private HashMap<String,Object> data;
    


@PostMapping("/guardar")
public ResponseEntity<HashMap<String, Object>> guardarDisponibilidad(@RequestBody HashMap<String, String> disponibilidad, Authentication authentication) {
    // Obtener el usuario autenticado
    CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    // Obtener los valores de fecha y hora desde el Map
    String fechaStr = disponibilidad.get("fecha");
    String horaInicialStr = disponibilidad.get("horaInicial");
    String horaFinalStr = disponibilidad.get("horaFinal");

    // Convertir fecha y horas a LocalDate y LocalTime
    LocalDate fecha = LocalDate.parse(fechaStr);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
    LocalTime horaInicial = LocalTime.parse(horaInicialStr,formatter);
    LocalTime horaFinal = LocalTime.parse(horaFinalStr,formatter);

    // Aquí puedes agregar la lógica para almacenar la disponibilidad en la base de datos
    // ...
    HorarioMedico horario = new HorarioMedico();
    Medico medico = medicoFacade.buscarMedicoPorId(userDetails.getIdCargo());
    horario.setMedico(medico);
    horario.setFecha(fecha);
    horario.setHoraFin(horaFinal);
    horario.setHoraInicio(horaInicial);

    horarioFacade.registrarHorarioMedico(horario);

    data = new HashMap<>();
    data.put("mensaje", "Disponibilidad guardada correctamente");


    return ResponseEntity.ok(data);
}

@GetMapping("/obtener")
public ResponseEntity<HashMap<LocalDate,List<String>>>obtenerHoras(@RequestParam("idMedico") Integer idMedico){
    System.out.println("-----------"+idMedico);
    return  ResponseEntity.ok(horarioFacade.obtenerHorasPorMedico(idMedico)) ;
}

}
