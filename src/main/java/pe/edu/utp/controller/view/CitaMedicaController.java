package pe.edu.utp.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.model.CitaMedica;
import pe.edu.utp.service.facade.CitaMedicaFacade;

@RestController
@RequestMapping("/cita")
public class CitaMedicaController {
    @Autowired
    CitaMedicaFacade citaFacade;

    @GetMapping("/confirmar/{id}")
    public String confirmarCita(@PathVariable("id") Integer id,Model model){
        CitaMedica cita = citaFacade.buscarCitaMedicaPorId(id);
        model.addAttribute("cita", cita);
        return "medico-cita-confirmar";
    }

}
