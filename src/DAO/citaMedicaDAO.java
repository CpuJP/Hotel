package DAO;

import Model.citaMedica;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class citaMedicaDAO {
    public void createCitaMedica(citaMedica cm){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "INSERT INTO cita_medica (Fecha, Bono, Medico_ID, Medico_Centro_Medico, Paciente_ID, Paciente_Centro_Medico) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, cm.getFechaHora());
            statement.setString(2, cm.getBono());
            statement.setString(3, cm.getMedicoId());
            statement.setString(4, cm.getMedicoCentroMedico());
            statement.setString(5, cm.getPacienteID());
            statement.setString(6, cm.getPacienteCentroMedico());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Inserción exitosa");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    
    public citaMedica getCitaMedicaCodigo(Integer codigo){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        citaMedica cm = null;
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "SELECT * FROM cita_medica WHERE Codigo=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setInt(1, codigo);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Integer codigo1 = rs.getInt(1);
                String fechaHora = rs.getString(2);
                String bono = rs.getString(3);
                String medicoId = rs.getString(4);
                String medicoCentroMedico = rs.getString(5);
                String pacienteID = rs.getString(6);
                String pacienteCentroMedico = rs.getString(7);
                cm = new citaMedica(codigo1, fechaHora, bono, medicoId, medicoCentroMedico, pacienteID, pacienteCentroMedico);
            }else{
                cm = new citaMedica(null, null, null, null, null, null, null);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cm;
    }
    
    public List<citaMedica> getAllCitaMedica(){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        List<citaMedica> citasMedicas = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "SELECT * FROM cita_medica";
            PreparedStatement statement = conn.prepareCall(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer codigo = rs.getInt(1);
                String fechaHora = rs.getString(2);
                String bono = rs.getString(3);
                String medicoId = rs.getString(4);
                String medicoCentroMedico = rs.getString(5);
                String pacienteID = rs.getString(6);
                String pacienteCentroMedico = rs.getString(7);
                citaMedica cm = new citaMedica(codigo, fechaHora, bono, medicoId, medicoCentroMedico, pacienteID, pacienteCentroMedico);
                citasMedicas.add(cm);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citasMedicas;
    }
    
    public void updateCitaMedica(citaMedica cm){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "UPDATE cita_medica SET Fecha=?, Bono=?, Medico_ID=?, Medico_Centro_Medico=?, Paciente_ID=?, Paciente_Centro_Medico=? WHERE codigo=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, cm.getFechaHora());
            statement.setString(2, cm.getBono());
            statement.setString(3, cm.getMedicoId());
            statement.setString(4, cm.getMedicoCentroMedico());
            statement.setString(5, cm.getPacienteID());
            statement.setString(6, cm.getPacienteCentroMedico());
            statement.setInt(7, cm.getCodigo());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Actualización exitosa");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteCitaMedica(Integer codigo){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "DELETE FROM cita_medica WHERE codigo=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setInt(1, codigo);
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Eliminación exitosa");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
