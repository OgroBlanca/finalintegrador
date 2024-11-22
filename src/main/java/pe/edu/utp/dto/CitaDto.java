package pe.edu.utp.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaDto {
    private Integer idCita;

    private String nombrePaciente;

    private String nombreMedico;

    private LocalDate fecha;

    private LocalTime hora;

    private String estado;

    private String detalle;

    private String pago;

   

    public CitaDto(Integer idCita, String nombrePaciente, String nombreMedico, LocalDate fecha, LocalTime hora,
            String estado, String detalle, String pago) {
        this.idCita = idCita;
        this.nombrePaciente = nombrePaciente;
        this.nombreMedico = nombreMedico;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.detalle = detalle;
        this.pago = pago;
    }

    public CitaDto() {
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
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

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    


}
