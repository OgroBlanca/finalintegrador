package pe.edu.utp.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.*;

@Entity
@Table(name = "Paciente")
public class Paciente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true)
    private Usuario usuario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(length = 20)
    private String telefono;

    @Column(length = 30)
    private String dni;

	@DateTimeFormat(iso = ISO.DATE)
    private LocalDate fechaNacimiento;

    public Paciente() {
		// TODO Auto-generated constructor stub
	}

	

	public Paciente(Integer idPaciente, Usuario usuario, String nombre, String apellidos, String telefono, String dni,
	LocalDate fechaNacimiento) {
		super();
		this.idPaciente = idPaciente;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}



	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}



	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
    
}