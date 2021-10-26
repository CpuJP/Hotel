package DAO;

import Model.covidPaciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class covidPacienteDAO {
    public void createCovidPaciente(covidPaciente cp){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "INSERT INTO Covid_Paciente (Contagio, Fecha_Contagio, Vacunado, Fecha_Vacunado, paciente_ID, paciente_Centro_Medico) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, cp.getContagio());
            statement.setString(2, cp.getFechaContagio());
            statement.setString(3, cp.getVacunado());
            statement.setString(4, cp.getFechaVacunado());
            statement.setString(5, cp.getPacienteId());
            statement.setString(6, cp.getPacienteCentroMedico());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Inserción exitosa");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    
    public covidPaciente getCovidPaciente(String id){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        covidPaciente cp = null;
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }   
            String sql = "SELECT * FROM covid_Paciente WHERE Paciente_ID=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String contagio = rs.getString(1);
                String fechaContagio = rs.getString(2);
                String vacunado = rs.getString(3);
                String fechaVacunado = rs.getString(4);
                String medicoId = rs.getString(5);
                String medicoCentroMedico = rs.getString(5);
                cp = new covidPaciente(contagio, fechaContagio, vacunado, fechaVacunado, medicoId, medicoCentroMedico);
            }else{
                cp = new covidPaciente(null, null, null, null, null, null);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return cp;
    }
    
    public List<covidPaciente> getAllCovidPaciente(){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        List<covidPaciente> covidPacientes = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "SELECT * FROM covid_paciente";
            PreparedStatement statement = conn.prepareCall(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String contagio = rs.getString(1);
                String fechaContagio = rs.getString(2);
                String vacunado = rs.getString(3);
                String fechaVacunado = rs.getString(4);
                String medicoId = rs.getString(5);
                String medicoCentroMedico = rs.getString(5);
                covidPaciente cm = new covidPaciente(contagio, fechaContagio, vacunado, fechaVacunado, medicoId, medicoCentroMedico);
                covidPacientes.add(cm);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return covidPacientes;
    }
    
    public void updateCovidPaciente(covidPaciente cp){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "UPDATE covid_paciente SET contagio=?, fecha_contagio=?, vacunado=?, fecha_vacundo=?, paciente_ID=?, paciente_Centro_Medico=? WHERE paciente_id=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, cp.getContagio());
            statement.setString(2, cp.getFechaContagio());
            statement.setString(3, cp.getVacunado());
            statement.setString(4, cp.getFechaVacunado());
            statement.setString(5, cp.getPacienteId());
            statement.setString(6, cp.getPacienteCentroMedico());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Actualización exitosa");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    
    public void deleteCovidPaciente(String id){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "DELETE FROM covid_paciente WHERE paciente_id=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
