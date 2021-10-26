package DAO;

import Model.covidMedico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class covidMedicoDAO {
    public void createCovidMedico(covidMedico cm){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "INSERT INTO Covid_Medico (Contagio, Fecha_Contagio, Vacunado, Fecha_Vacunado, Medico_ID, Medico_Centro_Medico) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, cm.getContagio());
            statement.setString(2, cm.getFechaContagio());
            statement.setString(3, cm.getVacunado());
            statement.setString(4, cm.getFechaVacunado());
            statement.setString(5, cm.getMedicoId());
            statement.setString(6, cm.getMedicoCentroMedico());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Inserción exitosa");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    
    public covidMedico getCovidMedico(String id){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        covidMedico cm = null;
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }   
            String sql = "SELECT * FROM covid_medico WHERE Medico_ID=?";
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
                cm = new covidMedico(contagio, fechaContagio, vacunado, fechaVacunado, medicoId, medicoCentroMedico);
            }else{
                cm = new covidMedico(null, null, null, null, null, null);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return cm;
    }
    
    public List<covidMedico> getAllCovidMedico(){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        List<covidMedico> covidmedicos = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "SELECT * FROM covid_medico";
            PreparedStatement statement = conn.prepareCall(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String contagio = rs.getString(1);
                String fechaContagio = rs.getString(2);
                String vacunado = rs.getString(3);
                String fechaVacunado = rs.getString(4);
                String medicoId = rs.getString(5);
                String medicoCentroMedico = rs.getString(5);
                covidMedico cm = new covidMedico(contagio, fechaContagio, vacunado, fechaVacunado, medicoId, medicoCentroMedico);
                covidmedicos.add(cm);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return covidmedicos;
    }
    
    public void updateCovidMedico(covidMedico cm){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "UPDATE covid_medico SET contagio=?, fecha_contagio=?, vacunado=?, fecha_vacundo=?, medico_ID=?, medico_Centro_Medico=? WHERE medico_id=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, cm.getContagio());
            statement.setString(2, cm.getFechaContagio());
            statement.setString(3, cm.getVacunado());
            statement.setString(4, cm.getFechaVacunado());
            statement.setString(5, cm.getMedicoId());
            statement.setString(6, cm.getMedicoCentroMedico());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Actualización exitosa");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    
    public void deleteCovidMedico(String id){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "DELETE FROM covid_medico WHERE medico_id=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
