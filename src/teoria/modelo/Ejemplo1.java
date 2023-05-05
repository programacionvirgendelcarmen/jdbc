package teoria.modelo;

import teoria.conexion.ConexionSingleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo1 {
    public static void main(String[] args) {
        //insert data
     /* String sqlInsert =
              "INSERT INTO usuario (nombre , dni ) VALUES (\"pepe lastra\", \"12345678b\");";
        try (Connection conexion = ConexionSingleton.getConexionSingleton().getConnection();
             Statement sentenciaInsert = conexion.createStatement()) {
            int rows = sentenciaInsert.executeUpdate(sqlInsert);
            System.out.printf("Registros insertados %d%n", rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        //update data
       /* String sqlUpdate =
                "UPDATE usuario SET nombre = 'juanito pérez' WHERE id = 1;";
        try (Connection conexion = ConexionSingleton.getConexionSingleton().getConnection();
             Statement sentenciaUpdate = conexion.createStatement()) {
            int rows = sentenciaUpdate.executeUpdate(sqlUpdate);
            System.out.printf("Registros actualizados %d%n", rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        //delete data
    }
}
