package DAO;

import Model.medico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class medicoDAO {
    
    public void createMedico(medico m){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "INSERT INTO Medico (ID, Nombre, Apellido, Telefono, Email, Especialidad, Centro_Medico_NIT) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, m.getId());
            statement.setString(2, m.getNombre());
            statement.setString(3, m.getApellido());
            statement.setString(4, m.getTelefono());
            statement.setString(5, m.getEmail());
            statement.setString(6, m.getEspecialidad());
            statement.setString(7, m.getCentroMedico());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Inserción exitosa");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public medico getMedicoId(String id){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        medico m = null;
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "SELECT * FROM medico WHERE ID=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String id1 = rs.getString(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String telefono = rs.getString(4);
                String email = rs.getString(5);
                String especialidad = rs.getString(6);
                String centroMedico = rs.getString(7);
                m = new medico(id1, nombre, apellido, telefono, email, especialidad, centroMedico);
            } else {
                m = new medico(null, null, null, null, null, null, null);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }
    
    public List<medico> getAllMedicos(){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        List<medico> medicos = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "SELECT * FROM medico";
            PreparedStatement statement = conn.prepareCall(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String telefono = rs.getString(4);
                String email = rs.getString(5);
                String especialidad = rs.getString(6);
                String centroMedico = rs.getString(7);
                medico m = new medico(id, nombre, apellido, telefono, email, especialidad, centroMedico);
                medicos.add(m);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicos;
    }
    
    public void updateMedico(medico m){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "UPDATE medico SET Nombre=?, Apellido=?, Telefono=?, Email=?, Especialidad=?, Centro_Medico_Nit=? WHERE ID=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, m.getNombre());
            statement.setString(2, m.getApellido());
            statement.setString(3, m.getTelefono());
            statement.setString(4, m.getEmail());
            statement.setString(5, m.getEspecialidad());
            statement.setString(6, m.getCentroMedico());
            statement.setString(7, m.getId());
            int rowsInserted = statement.executeUpdate();
            

            if (rowsInserted > 0) {
                System.out.println("Actualización exitosa");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteMedico(String id){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "DELETE FROM medico WHERE ID=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, id);
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
