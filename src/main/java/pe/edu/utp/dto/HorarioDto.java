package pe.edu.utp.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class HorarioDto {
    private String nombreMedico;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    public HorarioDto() {
    }
    public HorarioDto(String nombreMedico, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.nombreMedico = nombreMedico;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    public String getNombreMedico() {
        return nombreMedico;
    }
    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalTime getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
    public LocalTime getHoraFin() {
        return horaFin;
    }
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
    
}
