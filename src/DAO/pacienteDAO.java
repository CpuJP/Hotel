package DAO;

import Model.paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class pacienteDAO {
    public void createPaciente(paciente p){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "INSERT INTO Paciente (ID, Nombre, Apellido, Telefono, Email, Eps, Centro_Medico_NIT) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, p.getId());
            statement.setString(2, p.getNombre());
            statement.setString(3, p.getApellido());
            statement.setString(4, p.getTelefono());
            statement.setString(5, p.getEmail());
            statement.setString(6, p.getEps());
            statement.setString(7, p.getCentroMedico());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Inserción exitosa");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public paciente getPacienteId(String id){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        paciente p = null;
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "SELECT * FROM paciente WHERE ID=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String id1 = rs.getString(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String telefono = rs.getString(4);
                String email = rs.getString(5);
                String eps = rs.getString(6);
                String centroMedico = rs.getString(7);
                p = new paciente(id1, nombre, apellido, telefono, email, eps, centroMedico);
            } else {
                p = new paciente(null, null, null, null, null, null, null);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    
    public List<paciente> getAllPacientes(){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        List<paciente> pacientes = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "SELECT * FROM paciente";
            PreparedStatement statement = conn.prepareCall(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String telefono = rs.getString(4);
                String email = rs.getString(5);
                String eps = rs.getString(6);
                String centroMedico = rs.getString(7);
                paciente p = new paciente(id, nombre, apellido, telefono, email, eps, centroMedico);
                pacientes.add(p);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }
    
    public void updatePaciente(paciente p){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "UPDATE paciente SET Nombre=?, Apellido=?, Telefono=?, Email=?, Eps=?, Centro_Medico_Nit=? WHERE ID=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, p.getNombre());
            statement.setString(2, p.getApellido());
            statement.setString(3, p.getTelefono());
            statement.setString(4, p.getEmail());
            statement.setString(5, p.getEps());
            statement.setString(6, p.getCentroMedico());
            statement.setString(7, p.getId());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Actualización exitosa");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletePaciente(String id){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "DELETE FROM paciente WHERE ID=?";
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
