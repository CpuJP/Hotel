package Controller;

import DAO.covidMedicoDAO;
import Model.covidMedico;
import java.util.List;

public class covidMedicoController {
    
    public void saveCovidMedico(covidMedico cm){
        covidMedicoDAO cmd = new covidMedicoDAO();
        cmd.createCovidMedico(cm);
    }
    
    public covidMedico getCovidMedicoById(String id){
        covidMedicoDAO cmd = new covidMedicoDAO();
        return cmd.getCovidMedico(id);
    }
    
    public List<covidMedico> getCovidMedicos(){
        covidMedicoDAO cmd = new covidMedicoDAO();
        return cmd.getAllCovidMedico();
    }
    
    public void updateCovidMedico(covidMedico cm){
        covidMedicoDAO cmd = new covidMedicoDAO();
        cmd.updateCovidMedico(cm);
    }
    
    public void deleteCovidMedico(String id){
        covidMedicoDAO cmd = new covidMedicoDAO();
        cmd.deleteCovidMedico(id);
    }
}
