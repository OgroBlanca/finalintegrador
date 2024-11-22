package pe.edu.utp.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.utp.model.CitaMedica;
import pe.edu.utp.model.Empleado;
import pe.edu.utp.model.Medico;
import pe.edu.utp.service.facade.CitaMedicaFacade;
import pe.edu.utp.service.facade.EmpleadoFacade;
import pe.edu.utp.service.facade.MedicoFacade;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CitaMedicaFacade citaFacade;
    @Autowired
    MedicoFacade medicoFacade;
    @Autowired
    EmpleadoFacade empleadoFacade;


    @GetMapping("/dashboard")
    public String dashboard(Model model){
     List<CitaMedica> citas = citaFacade.obtenerTodasCitasMedicas();
     List<Empleado> empleados = empleadoFacade.obtenerTodosEmpleados();
     List<Medico> medicos = medicoFacade.obtenerTodosMedicos();
     //Cantidad de los medicos y empleados
     int cantEmpl = empleados.size();
     int cantMed = medicos.size();
     model.addAttribute("numEmpleados", cantEmpl);
     model.addAttribute("numMedicos", cantMed);
     model.addAttribute("citas", citas);
     return "admin-home";
    }

    @GetMapping("/reportes")
    public String reportes(){
        return "admin-reportes";
       }


    
}
