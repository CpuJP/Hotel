package DAO;

import Model.centroMedico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class centroMedicoDAO {
    
    //Se crea un metodo para crear centros medicos
    public void createCentroMedico(centroMedico cm){
        //Estas tres lineas se usan para conectar el metodo con la base de datos
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        
        //Todo tipo de sentencia sql que se vaya a realizar debe ir dentro de un try catch
        try {
            
            //Se mandan los datos como url, usuario y contraseña para poder acceder a la base de datos
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            
            //Esta lina de String es donde se pone la sentencia sql para que opere en la base de datos
            String sql = "INSERT INTO centro_medico (NIT, Nombre_Centro_Medico, Telefono, Email, Nivel) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            //Se leen los datos para enviarlos a la base de datos
            statement.setString(1, cm.getNit());
            statement.setString(2, cm.getNombreCentroMedico());
            statement.setString(3, cm.getTelefono());
            statement.setString(4, cm.getEmail());
            statement.setInt(5, cm.getNivel());
            
            //Se comprueba si se insertaron los datos correctamente
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Inserción exitosa");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public centroMedico getCentroMedicoCodigo(String nit){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        centroMedico cm = null;
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "SELECT * FROM centro_medico WHERE NIT=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, nit);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String nit1 = rs.getString(1);
                String nombreCentroMedico = rs.getString(2);
                String telefono = rs.getString(3);
                String email = rs.getString(4);
                Integer nivel = rs.getInt(5);
                cm = new centroMedico(nit1, nombreCentroMedico, telefono, email, nivel);
            }else{
                cm = new centroMedico(null, null, null, null, null);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cm;
    }
    
    public List<centroMedico> getAllCentroMedico(){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        List<centroMedico> centrosMedicos = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "SELECT * FROM centro_medico";
            PreparedStatement statement = conn.prepareCall(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String nit1 = rs.getString(1);
                String nombreCentroMedico = rs.getString(2);
                String telefono = rs.getString(3);
                String email = rs.getString(4);
                Integer nivel = rs.getInt(5);
                centroMedico cm = new centroMedico(nit1, nombreCentroMedico, telefono, email, nivel);
                centrosMedicos.add(cm);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return centrosMedicos;
    }
    
    public void updateCentroMedico(centroMedico cm){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "UPDATE centro_medico SET Nombre_Centro_Medico=?, Telefono=?, Email=?, Nivel=? WHERE NIT=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, cm.getNit());
            statement.setString(2, cm.getNombreCentroMedico());
            statement.setString(3, cm.getTelefono());
            statement.setString(4, cm.getEmail());
            statement.setInt(5, cm.getNivel());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Actualización exitosa");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteCentroMedico(String nit){
        String dbURL = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "juanpablo1870";
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                
            }else{
                System.out.println("Problemas al conectar");
            }
            String sql = "DELETE FROM centro_medico WHERE nit=?";
            PreparedStatement statement = conn.prepareCall(sql);
            statement.setString(1, nit);
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
