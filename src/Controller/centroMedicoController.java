package Controller;

import DAO.centroMedicoDAO;
import Model.centroMedico;
import java.util.List;

public class centroMedicoController {
    
    //Estos son los metodos que se van a usar en la vista
    public void saveCentroMedico(centroMedico cm){
        centroMedicoDAO cmd = new centroMedicoDAO();
        cmd.createCentroMedico(cm);
    }
    
    public centroMedico getCentroMedicoByNit(String nit){
        centroMedicoDAO cmd = new centroMedicoDAO();
        return cmd.getCentroMedicoCodigo(nit);
    }
    
    public List<centroMedico> getCentrosMedicos(){
        centroMedicoDAO cmd = new centroMedicoDAO();
        return cmd.getAllCentroMedico();
    }
    
    public void updateCentroMedico(centroMedico cm){
        centroMedicoDAO cmd = new centroMedicoDAO();
        cmd.updateCentroMedico(cm);
    }
    
    public void deleteCentroMedico(String nit){
        centroMedicoDAO cmd = new centroMedicoDAO();
        cmd.deleteCentroMedico(nit);
    }
}
