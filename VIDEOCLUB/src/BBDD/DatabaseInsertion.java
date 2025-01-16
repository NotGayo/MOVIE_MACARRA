package BBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabaseInsertion {
    public static void insertarUsuario(int codUs, String nombre, String correo, String contrasena, String esad) {
        String sql = "INSERT INTO Usuario(codigoUsuario, nombre, correo, contrasena, esadmin) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codUs);
            pstmt.setString(2, nombre);
            pstmt.setString(3, correo);
            pstmt.setString(4, contrasena);
            pstmt.setString(5, esad);
            pstmt.executeUpdate();
            System.out.println("Estudiante añadido correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }
}

