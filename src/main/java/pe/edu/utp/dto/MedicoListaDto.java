package pe.edu.utp.dto;

public class MedicoListaDto {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private Integer idEspecialidad;
    public MedicoListaDto(Integer id, String nombre, String apellidos, String telefono, String direccion,
            Integer idEspecialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.idEspecialidad = idEspecialidad;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    

    
}
