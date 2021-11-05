package Controller;

import DAO.pacienteDAO;
import Model.paciente;
import java.util.List;

public class pacienteController {
    
    public void savePaciente(paciente p){
        pacienteDAO pd = new pacienteDAO();
        pd.createPaciente(p);
    }
    
    public paciente getPacienteById(String id){
        pacienteDAO pd = new pacienteDAO();
        return pd.getPacienteId(id);
    }
    
    public List<paciente> getPacientes(){
        pacienteDAO pd = new pacienteDAO();
        return pd.getAllPacientes();
    }
    
    public void updatePaciente(paciente p){
        pacienteDAO pd = new pacienteDAO();
        pd.updatePaciente(p);
    }
    
    public void deletePaciente(String id){
        pacienteDAO pd = new pacienteDAO();
        pd.deletePaciente(id);
    }
}
