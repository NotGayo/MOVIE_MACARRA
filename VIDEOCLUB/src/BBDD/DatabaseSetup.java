package BBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    
	
	public static void createTables() {
		String sql = "CREATE TABLE ALQUILA (correo text NOT NULL PRIMARY KEY, codigoPelicula bigint NOT NULL , Fecha time NOT NULL, Hora timestamp NOT NULL); "
				+ "CREATE TABLE USUARIO (nombre text NOT NULL, correo text NOT NULL PRIMARY KEY, contrasena text NOT NULL, fechan DATE NOT NULL, codAdminAceptador text, codAdminEliminador text, esValido text); "
				+ "CREATE TABLE PELICULA (codigoPelicula bigint NOT NULL PRIMARY KEY, titulo text, director text, año bigint, actores text, archivoVideo text, descripcion text, correoAdminAnade text, correoAdminBorra text); "
				+ "CREATE TABLE PROPUESTA (correo text NOT NULL PRIMARY KEY, titulo text); "
				+ "CREATE TABLE VALORACION (correo text NOT NULL PRIMARY KEY, codigoPelicula bigint NOT NULL PRIMARY KEY, puntuacion bigint, reseña bigint);"
				+ "ALTER TABLE PELICULA ADD CONSTRAINT PELICULA_codigoPelicula_fk FOREIGN KEY (codigoPelicula) REFERENCES VALORACION (codigoPelicula); "
				+ "ALTER TABLE PELICULA ADD CONSTRAINT PELICULA_codigoPelicula_fk FOREIGN KEY (codigoPelicula) REFERENCES ALQUILA (codigoPelicula); "
				+ "ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_correo_fk FOREIGN KEY (correo) REFERENCES VALORACION (correo); "
				+ "ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_correo_fk FOREIGN KEY (correo) REFERENCES PELICULA (correoAdminAnade); "
				+ "ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_correo_fk FOREIGN KEY (correo) REFERENCES ALQUILA (correo); "
				+ "ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_correo_fk FOREIGN KEY (correo) REFERENCES PROPUESTA (correo);";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla 'usuario' creada o ya existe.");
        } catch (Exception e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
	
	public static void checkDB() {
	    String sql = "SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE, IS_NULLABLE, COLUMN_DEFAULT " +
	                 "FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'nombre_de_tu_base_de_datos'";

	    try (Connection conn = DatabaseConnection.connect();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        System.out.println("Información de todas las tablas y columnas:");
	        while (rs.next()) {
	            String tableName = rs.getString("TABLE_NAME");
	            String columnName = rs.getString("COLUMN_NAME");
	            String dataType = rs.getString("DATA_TYPE");
	            String isNullable = rs.getString("IS_NULLABLE");
	            String columnDefault = rs.getString("COLUMN_DEFAULT");

	            System.out.printf("Tabla: %s, Columna: %s, Tipo: %s, Acepta NULL: %s, Valor por defecto: %s%n",
	                    tableName, columnName, dataType, isNullable, columnDefault);
	        }
	    } catch (Exception e) {
	        System.out.println("Error al consultar la base de datos: " + e.getMessage());
	    }
	}

	
	public static void dropDatabase() {
	    String sql = "DROP DATABASE videoclub.db";  // Reemplaza con el nombre de tu base de datos

	    try (Connection conn = DatabaseConnection.connect();
	         Statement stmt = conn.createStatement()) {

	        // Ejecuta el comando para eliminar la base de datos
	        stmt.executeUpdate(sql);
	        System.out.println("Base de datos eliminada con éxito.");

	    } catch (SQLException e) {
	        System.out.println("Error al eliminar la base de datos: " + e.getMessage());
	    }
	}

	
	public static void deleteAllData() {
	    String getAllTablesSQL = "SELECT name FROM sqlite_master WHERE type='table' AND name NOT LIKE 'sqlite_%';";
	    try (Connection conn = DatabaseConnection.connect();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(getAllTablesSQL)) {
	        
	        while (rs.next()) {
	            String tableName = rs.getString("name");
	            String dropTableSQL = "DROP TABLE IF EXISTS " + tableName + ";";
	            stmt.execute(dropTableSQL);
	            System.out.println("Tabla " + tableName + " eliminada.");
	        }
	        
	        System.out.println("Todas las tablas han sido eliminadas.");
	    } catch (Exception e) {
	        System.out.println("Error al eliminar las tablas: " + e.getMessage());
	    }
	}

	
}
