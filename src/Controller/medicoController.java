package Controller;

import DAO.medicoDAO;
import Model.medico;
import java.util.List;

public class medicoController {
    
    public void saveMedico(medico m){
        medicoDAO md = new medicoDAO();
        md.createMedico(m);
    }
    
    public medico getMedicoById(String id){
        medicoDAO md = new medicoDAO();
        return md.getMedicoId(id);
    }
    
    public List<medico> getMedicos(){
        medicoDAO md = new medicoDAO();
        return md.getAllMedicos();
    }
    
    public void updateMedico(medico m){
        medicoDAO md = new medicoDAO();
        md.updateMedico(m);
    }
    
    public void deleteMedico(String id){
        medicoDAO md = new medicoDAO();
        md.deleteMedico(id);
    }
}
