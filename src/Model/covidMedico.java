package Model;

public class covidMedico {
    private String contagio;
    private String fechaContagio;
    private String vacunado;
    private String fechaVacunado;
    private String medicoId;
    private String medicoCentroMedico;

    public covidMedico(String contagio, String fechaContagio, String vacunado, String fechaVacunado, String medicoId, String medicoCentroMedico) {
        if (contagio == null || contagio.length() == 0) {
            this.contagio = "NO";
        }else{
            this.contagio = contagio;
        }
        this.fechaContagio = fechaContagio;
        if (vacunado == null || vacunado.length() == 0) {
            this.vacunado = "NO";
        }else{
            this.vacunado = vacunado;
        }
        this.fechaVacunado = fechaVacunado;
        this.medicoId = medicoId;
        this.medicoCentroMedico = medicoCentroMedico;
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
    
    
}
