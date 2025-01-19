package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BBDD.DatabaseConnection;
import BBDD.DatabaseSetup;
import controller.VideoClub;

public class main {
    public static void main(String[] args) {
        String dbUrl = "jdbc:sqlite:videoclub.db";  // Cambia esto por la ruta de tu archivo .db

        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            // Consulta para obtener las tablas en la base de datos
            String sql = "SELECT name FROM sqlite_master WHERE type='table'";

            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                System.out.println("Tablas en la base de datos:");
                while (rs.next()) {
                    System.out.println(rs.getString("name"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar o consultar la base de datos: " + e.getMessage());
        }
    }
}
