package pe.edu.utp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rol")
public class Rol {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_rol", nullable = false)
    private RolEnum nombreRol;

    public enum RolEnum {
        ADMIN, MEDICO, RECEPCIONISTA, PACIENTE
    }

    public Rol() {
		// TODO Auto-generated constructor stub
	}

	public Rol(Integer idRol, RolEnum nombreRol) {
		super();
		this.idRol = idRol;
		this.nombreRol = nombreRol;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public RolEnum getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(RolEnum nombreRol) {
		this.nombreRol = nombreRol;
	}
    
	
}