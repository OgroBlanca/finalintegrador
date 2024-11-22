package pe.edu.utp.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/servicios")
    public String servicios() {
        return "servicios";
    }

    @GetMapping("/nosotros")
    public String nosotros() {
        return "nosotros";
    }
    
    @GetMapping("/doctor")
    public String doctor() {
        return "doctor"; 
    }
    @GetMapping("/reserva")
    public String reserva(){
        return "paciente-reserva";
    }
}
