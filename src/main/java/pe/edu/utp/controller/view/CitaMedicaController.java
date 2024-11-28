package pe.edu.utp.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.utp.dto.CitaDto;
import pe.edu.utp.model.CitaMedica;
import pe.edu.utp.model.CitaMedica.EstadoCita;
import pe.edu.utp.service.facade.CitaMedicaFacade;

@Controller
@RequestMapping("/cita")
public class CitaMedicaController {
    @Autowired
    CitaMedicaFacade citaFacade;
    
    @PreAuthorize("hasRole('ROLE_MEDICO')")
    @GetMapping("/confirmar/{id}")
    public String confirmarCita(@PathVariable("id") Integer id,Model model){
        CitaMedica cita = citaFacade.buscarCitaMedicaPorId(id);
        CitaDto citaDto = new CitaDto(cita.getIdCita(),cita.getPaciente().getNombre(),
                                cita.getMedico().getNombre(),cita.getFecha(),cita.getHora(),cita.getEstado().name()
                                ,cita.getDetalle(),cita.getPago().name());
        model.addAttribute("citaDto", citaDto);
        return "medico-cita-confirmar";
    }

    @PreAuthorize("hasRole('ROLE_MEDICO')")
    @PostMapping("/confirmar")
    public String confirmarCita(@ModelAttribute CitaDto citaDto,Model model){
        CitaMedica cita = citaFacade.buscarCitaMedicaPorId(citaDto.getIdCita());
        cita.setEstado(EstadoCita.CONFIRMADA);
        cita.setDetalle(citaDto.getDetalle());
        citaFacade.actualizarCitaMedica(cita);
        
        model.addAttribute("citaDto", citaDto);
        return "redirect:/medico/citasPendientes";
    }

}
