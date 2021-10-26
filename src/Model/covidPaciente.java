package Model;

public class covidPaciente {
    private String contagio;
    private String fechaContagio;
    private String vacunado;
    private String fechaVacunado;
    private String pacienteId;
    private String pacienteCentroMedico;

    public covidPaciente(String contagio, String fechaContagio, String vacunado, String fechaVacunado, String pacienteId, String pacienteCentroMedico) {
        this.contagio = contagio;
        this.fechaContagio = fechaContagio;
        this.vacunado = vacunado;
        this.fechaVacunado = fechaVacunado;
        this.pacienteId = pacienteId;
        this.pacienteCentroMedico = pacienteCentroMedico;
    }

    public String getContagio() {
        return contagio;
    }

    public void setContagio(String contagio) {
        this.contagio = contagio;
    }

    public String getFechaContagio() {
        return fechaContagio;
    }

    public void setFechaContagio(String fechaContagio) {
        this.fechaContagio = fechaContagio;
    }

    public String getVacunado() {
        return vacunado;
    }

    public void setVacunado(String vacunado) {
        this.vacunado = vacunado;
    }

    public String getFechaVacunado() {
        return fechaVacunado;
    }

    public void setFechaVacunado(String fechaVacunado) {
        this.fechaVacunado = fechaVacunado;
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getPacienteCentroMedico() {
        return pacienteCentroMedico;
    }

    public void setPacienteCentroMedico(String pacienteCentroMedico) {
        this.pacienteCentroMedico = pacienteCentroMedico;
    }
    
}
