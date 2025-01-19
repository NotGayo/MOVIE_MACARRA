package BBDD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseSelection {

	
	 public static void selectUsuario() {
	        String sql = "SELECT * FROM USUARIO";

	        try (Connection conn = DatabaseConnection.connect();
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.executeQuery();
	            
	            ResultSet rs = pstmt.executeQuery();

	            // Procesar los resultados
	            while (rs.next()) {
	                System.out.println("Nombre: " + rs.getString("nombre"));
	                System.out.println("Correo: " + rs.getString("correo"));
	                System.out.println("Fecha de nacimiento: " + rs.getDate("fechan"));
	                System.out.println("Contraseña: " + rs.getString("contrasena"));
	                System.out.println("-----------------------------");
	            }
	            System.out.println("ok");
	        } catch (Exception e) {
	            System.out.println("Error al insertar datos: " + e.getMessage());
	        }
	    }
}
