package pe.edu.utp.dto;

public class MedicoDto {

    // Atributos de Medico
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private Integer idEspecialidad;

    // Atributos de Usuario
    private String correo;
    private String contrasena;
    private Integer idRol;

    public MedicoDto(String nombre, String apellidos, String telefono, String direccion, Integer idEspecialidad,
            String correo, String contrasena, Integer idRol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.idEspecialidad = idEspecialidad;
        this.correo = correo;
        this.contrasena = contrasena;
        this.idRol = idRol;
    }

    public MedicoDto() {
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

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }


}
