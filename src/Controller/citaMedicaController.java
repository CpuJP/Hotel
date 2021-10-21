package Controller;

import DAO.citaMedicaDAO;
import Model.citaMedica;
import java.util.List;

public class citaMedicaController {
    
    public void saveCitaMedica(citaMedica cm){
        citaMedicaDAO cmd = new citaMedicaDAO();
        cmd.createCitaMedica(cm);
    }
    
    public citaMedica getCitaMedicaByCodigo(Integer codigo){
        citaMedicaDAO cmd = new citaMedicaDAO();
        return cmd.getCitaMedicaCodigo(codigo);
    }
    
    public List<citaMedica> getCitasMedicas(){
        citaMedicaDAO cmd = new citaMedicaDAO();
        return cmd.getAllCitaMedica();
    } 
    
    public void updateCitaMedica(citaMedica cm){
        citaMedicaDAO cmd = new citaMedicaDAO();
        cmd.updateCitaMedica(cm);
    }
    
    public void deleteCitaMedica(Integer codigo){
        citaMedicaDAO cmd = new citaMedicaDAO();
        cmd.deleteCitaMedica(codigo);
    }
}
