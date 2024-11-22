package pe.edu.utp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Medico")
public class Medico{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedico;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", unique = true)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    private Especialidad especialidad;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(length = 20)
    private String telefono;

    @Column(length = 300)
    private String direccion;

    public Medico() {
		// TODO Auto-generated constructor stub
	}

	public Medico(Integer idMedico, Usuario usuario, Especialidad especialidad, String nombre, String apellidos,
			String telefono, String direccion) {
		super();
		this.idMedico = idMedico;
		this.usuario = usuario;
		this.especialidad = especialidad;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Integer getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
    
	
}