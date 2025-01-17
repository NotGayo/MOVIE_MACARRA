package BBDD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class DatabaseInsertion {
    public static void insertarUsuario(String nombre, String correo, String contrasena,Date fechaN) {
        String sql = "INSERT INTO Usuario(nombre, correo, contrasena, fechaNacimiento) VALUES(?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, correo);
            pstmt.setString(3, contrasena);
            pstmt.setDate(4, fechaN);
            pstmt.executeUpdate();
            System.out.println("Estudiante añadido correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }
}

