package pe.edu.utp.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.utp.model.Especialidad;
import pe.edu.utp.service.facade.EspecialidadFacade;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    EspecialidadFacade especialidadFacade;

    @GetMapping("/reservar")
    public String reservar(Model model){
        List<Especialidad> especialidades = especialidadFacade.obtenerTodasEspecialidades();
        model.addAttribute("especialidades",especialidades);
        return "paciente-reserva";
    }
}
