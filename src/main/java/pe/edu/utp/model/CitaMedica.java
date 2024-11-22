package pe.edu.utp.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "Cita_Medica")
public class CitaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;

	@Column(name="fecha")
	@DateTimeFormat(iso = ISO.DATE)
    private LocalDate fecha;
	@Column(name="hora")
	@DateTimeFormat(iso = ISO.TIME)
    private LocalTime hora;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCita estado;

    public enum EstadoCita {
        CONFIRMADA, EN_ESPERA, CANCELADA
    }

    @Column(columnDefinition = "TEXT")
    private String detalle;

    @Enumerated(EnumType.STRING)
    private PagoCita pago;

    public enum PagoCita {
        TARJETA, EFECTIVO
    }
    
    public CitaMedica() {
		// TODO Auto-generated constructor stub
	}
    
    

	public CitaMedica(Integer idCita, Paciente paciente, Medico medico, LocalDate fecha, LocalTime hora,
			EstadoCita estado, String detalle, PagoCita pago) {
		super();
		this.idCita = idCita;
		this.paciente = paciente;
		this.medico = medico;
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
		this.detalle = detalle;
		this.pago = pago;
	}






	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public EstadoCita getEstado() {
		return estado;
	}

	public void setEstado(EstadoCita estado) {
		this.estado = estado;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public PagoCita getPago() {
		return pago;
	}

	public void setPago(PagoCita pago) {
		this.pago = pago;
	}
    
    

    // Getters y setters
}