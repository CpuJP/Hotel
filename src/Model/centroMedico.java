package Model;

public class centroMedico {
    //Se declaran todos los datos que usa la tabla
    private String nit;
    private String nombreCentroMedico;
    private String telefono;
    private String email;
    private Integer nivel;

    //Se genera solo el constructor sobre cargado

    public centroMedico(String nit, String nombreCentroMedico, String telefono, String email, Integer nivel) {
        this.nit = nit;
        this.nombreCentroMedico = nombreCentroMedico;
        this.telefono = telefono;
        this.email = email;
        this.nivel = nivel;
    }

    //En los gets y sets se generan todos, solo se borra el set del id
    public String getNit() {
        return nit;
    }

    public String getNombreCentroMedico() {
        return nombreCentroMedico;
    }

    public void setNombreCentroMedico(String nombreCentroMedico) {
        this.nombreCentroMedico = nombreCentroMedico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
     
    