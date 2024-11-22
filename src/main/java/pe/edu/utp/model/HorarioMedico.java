package pe.edu.utp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "Horario_Medico")
public class HorarioMedico  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHorario;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;

	@DateTimeFormat(iso = ISO.DATE)
    private LocalDate fecha;

	@DateTimeFormat(iso = ISO.TIME)
    private LocalTime horaInicio;
	
	@DateTimeFormat(iso = ISO.TIME)
    private LocalTime horaFin;

    public HorarioMedico(Integer idHorario, Medico medico, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
		this.idHorario = idHorario;
		this.medico = medico;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public HorarioMedico() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
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