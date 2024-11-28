package pe.edu.utp.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.utp.dto.PerfilDto;
import pe.edu.utp.model.CitaMedica;
import pe.edu.utp.model.Especialidad;
import pe.edu.utp.model.Paciente;
import pe.edu.utp.security.CustomUserDetails;
import pe.edu.utp.service.facade.CitaMedicaFacade;
import pe.edu.utp.service.facade.EspecialidadFacade;
import pe.edu.utp.service.facade.PacienteFacade;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    EspecialidadFacade especialidadFacade;
    @Autowired
    PacienteFacade pacienteFacade;
    @Autowired
    CitaMedicaFacade citaFacade;

    @PreAuthorize("hasRole('ROLE_PACIENTE')")
    @GetMapping("/reservar")
    public String reservar(Model model){
        List<Especialidad> especialidades = especialidadFacade.obtenerTodasEspecialidades();
        model.addAttribute("especialidades",especialidades);
        return "paciente-reserva";
    }

    @PreAuthorize("hasRole('ROLE_PACIENTE')")
    @GetMapping("/perfil")
    public String perfil(Model model,Authentication authentication){
        //obtener datos del usuario
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Paciente paciente = pacienteFacade.buscarPacientePorId(userDetails.getIdCargo());
        PerfilDto perfilDto = new PerfilDto(paciente.getNombre(),paciente.getApellidos(),paciente.getTelefono());
        //citas
        List<CitaMedica> citas = citaFacade.obtenerCitasPorPaciente(userDetails.getIdCargo());
        model.addAttribute("perfilDto",perfilDto);
        model.addAttribute("citas", citas);
        return "perfil";
    }
}
