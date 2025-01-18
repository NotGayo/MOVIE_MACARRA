package BBDD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class DatabaseUpdate {
	public static void updateNombre(String correo, String nombre) {
        String sql = "UPDATE USUARIO WHERE correo = ? SET nombre = ?";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, correo);
            pstmt.setString(2, nombre);
            
            pstmt.executeUpdate();
            System.out.println("Estudiante añadido correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }
	
	public static void updateContra(String correo, String contrasena) {
        String sql = "UPDATE USUARIO WHERE correo = ? SET contrasena = ?";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, correo);
            pstmt.setString(2, contrasena);
            
            pstmt.executeUpdate();
            System.out.println("Estudiante añadido correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }
}
