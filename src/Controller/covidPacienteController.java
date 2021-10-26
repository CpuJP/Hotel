package Controller;

import Model.covidPaciente;
import DAO.covidPacienteDAO;
import java.util.List;

public class covidPacienteController {
    public void saveCovidMedico(covidPaciente cm){
        covidPacienteDAO cmd = new covidPacienteDAO();
        cmd.createCovidPaciente(cm);
    }
    
    public covidPaciente getCovidMedicoById(String id){
        covidPacienteDAO cmd = new covidPacienteDAO();
        return cmd.getCovidPaciente(id);
    }
    
    public List<covidPaciente> getCovidMedicos(){
        covidPacienteDAO cmd = new covidPacienteDAO();
        return cmd.getAllCovidPaciente();
    }
    
    public void updateCovidMedico(covidPaciente cm){
        covidPacienteDAO cmd = new covidPacienteDAO();
        cmd.updateCovidPaciente(cm);
    }
    
    public void deleteCovidMedico(String id){
        covidPacienteDAO cmd = new covidPacienteDAO();
        cmd.deleteCovidPaciente(id);
    }
}
