package Model;

public class citaMedica {
    //Se declaran todos los datos de la tabla, incluso las llaves foraneas
    private Integer codigo;
    private String fechaHora;
    private String bono;
    private String medicoId;
    private String medicoCentroMedico;
    private String pacienteID;
    private String pacienteCentroMedico;
    
    //Se genera solo el constructor sobre cargado
    public citaMedica(Integer codigo, String fechaHora, String bono, String medicoId, String medicoCentroMedico, String pacienteID, String pacienteCentroMedico) {
        this.codigo = codigo;
        this.fechaHora = fechaHora;
        //Se genera un if para los datos que son tipo ENUM y tiene un default
        if (bono == null || bono.length() == 0) {
            //Se ingresa el valor que esta en default
            this.bono = "NO";
        }else{
            //Se ingresa uno de los valores permitidos
            this.bono = bono;
        }
        this.medicoId = medicoId;
        this.medicoCentroMedico = medicoCentroMedico;
        this.pacienteID = pacienteID;
        this.pacienteCentroMedico = pacienteCentroMedico;
    }
    
    //Se crean todos los gets y sets, se elimina el set del id
    public Integer getCodigo() {
        return codigo;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getBono() {
        return bono;
    }

    public void setBono(String bono) {
        this.bono = bono;
    }

    public String getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(String medicoId) {
        this.medicoId = medicoId;
    }

    public String getMedicoCentroMedico() {
        return medicoCentroMedico;
    }

    public void setMedicoCentroMedico(String medicoCentroMedico) {
        this.medicoCentroMedico = medicoCentroMedico;
    }

    public String getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(String pacienteID) {
        this.pacienteID = pacienteID;
    }

    public String getPacienteCentroMedico() {
        return pacienteCentroMedico;
    }

    public void setPacienteCentroMedico(String pacienteCentroMedico) {
        this.pacienteCentroMedico = pacienteCentroMedico;
    }
    
    
    
    
    
}
