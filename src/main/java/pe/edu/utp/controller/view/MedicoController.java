package pe.edu.utp.controller.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.utp.dto.CitaDto;
import pe.edu.utp.dto.MedicoDto;
import pe.edu.utp.model.CitaMedica;
import pe.edu.utp.model.Especialidad;
import pe.edu.utp.model.HorarioMedico;
import pe.edu.utp.model.Medico;
import pe.edu.utp.model.Rol;
import pe.edu.utp.model.Usuario;
import pe.edu.utp.model.CitaMedica.EstadoCita;
import pe.edu.utp.security.CustomUserDetails;
import pe.edu.utp.service.facade.CitaMedicaFacade;
import pe.edu.utp.service.facade.EspecialidadFacade;
import pe.edu.utp.service.facade.HorarioMedicoFacade;
import pe.edu.utp.service.facade.MedicoFacade;
import pe.edu.utp.service.facade.RolFacade;
import pe.edu.utp.service.facade.UsuarioFacade;

@Controller
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    MedicoFacade medicoFacade;
    @Autowired
    EspecialidadFacade especialidadFacade;
    @Autowired
    RolFacade rolFacade;
    @Autowired
    CitaMedicaFacade citaFacade;
    @Autowired
    HorarioMedicoFacade horarioFacade;

    @Autowired
    UsuarioFacade usuarioFacade;

    @GetMapping("/listar")
    public String medicos(Model model) {
        List<Medico> medicos = medicoFacade.obtenerTodosMedicos();
        MedicoDto medicoDto = new MedicoDto();
        List<Especialidad> especialidades = especialidadFacade.obtenerTodasEspecialidades();
        model.addAttribute("medicos", medicos);
        model.addAttribute("medicoDto", medicoDto);
        model.addAttribute("especialidades", especialidades);
        return "admin-medicos";
    }

    @PostMapping("/crear")
    public String crearMedico(@ModelAttribute MedicoDto medicoDto) {
        Medico medico = new Medico();
        Rol rol = rolFacade.findById(medicoDto.getIdRol());
        Especialidad especialidad = especialidadFacade.buscarEspecialidadPorId(medicoDto.getIdEspecialidad());
        Usuario usuario = new Usuario(null, medicoDto.getCorreo(), medicoDto.getContrasena(), rol);
        usuarioFacade.guardarUsuario(usuario);

        medico.setNombre(medicoDto.getNombre());
        medico.setApellidos(medicoDto.getApellidos());
        medico.setEspecialidad(especialidad);
        medico.setDireccion(medicoDto.getDireccion());
        medico.setTelefono(medicoDto.getTelefono());
        medico.setUsuario(usuario);

        medicoFacade.registrarMedico(medico);
        return "redirect:/medico/listar";
    }

    @GetMapping("/buscar")
    public String buscarMedico(@RequestParam("nombre") String nombre, Model model) {
        List<Medico> medicos = medicoFacade.buscarMedicos(nombre);
        MedicoDto medicoDto = new MedicoDto();
        List<Especialidad> especialidades = especialidadFacade.obtenerTodasEspecialidades();
        model.addAttribute("medicos", medicos);
        model.addAttribute("medicoDto", medicoDto);
        model.addAttribute("especialidades", especialidades);
        return "admin-medicos";

    }

    @GetMapping("/home")
    public String dashboard(Model model){
      List<CitaMedica> citasMedicas = citaFacade.obtenerTodasCitasMedicas();
      List<CitaDto> citas = new ArrayList<>();
      for (CitaMedica cita : citasMedicas) {
        citas.add(new CitaDto(cita.getIdCita(),cita.getPaciente().getNombre(),cita.getMedico().getNombre(),cita.getFecha(),cita.getHora(),cita.getEstado().name(),cita.getDetalle(),cita.getPago().name()));
      }
       model.addAttribute("citas", citas);
       return "medico-home";
    }


    @GetMapping("/disponibilidad")
    public String disponibilidad(Model model,Authentication authentication){
    // Obtener el usuario autenticado
    CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    List<HorarioMedico> horarios = horarioFacade.obtenerHorariosPorMedico(userDetails.getIdCargo());
    model.addAttribute("horarios", horarios);
    return "medico-disponibilidad";
    }

    @GetMapping("/citasRealizadas")
    public String citasRealizadas(Model model, Authentication authentication){
      // Obtener el usuario autenticado
    CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    List<CitaMedica> citas = citaFacade.obtenerCitasPorMedicos(userDetails.getIdCargo(),EstadoCita.CONFIRMADA);
    model.addAttribute("citas", citas);
    return "medico-citas-realizadas";
    }

    @GetMapping("/citasPendientes")
    public String citasPendientes(Model model, Authentication authentication){
      // Obtener el usuario autenticado
    CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    List<CitaMedica> citas = citaFacade.obtenerCitasPorMedicos(userDetails.getIdCargo(),EstadoCita.EN_ESPERA);
    model.addAttribute("citas", citas);
    return "medico-citas-pendientes";
    }


    

}
