package teoria.modelo;

import teoria.conexion.ConexionSingleton;

import java.sql.*;
import java.util.Scanner;

public class Ejemplo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //insert data
      /*String sqlInsert =
              "INSERT INTO usuario (nombre , dni ) VALUES (\"pepi garcía\", \"12345678d\");";
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
        /*//delete data
         String sqlDelete =
                 "DELETE FROM usuario WHERE dni = '12345678b';";
        try (Connection conexion = ConexionSingleton.getConexionSingleton().getConnection();
             Statement sentenciaDelete = conexion.createStatement()) {
            int rows = sentenciaDelete.executeUpdate(sqlDelete);
            System.out.printf("Registros eliminados %d%n", rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        
        //read data
       /* String sqlSelect = "select * from usuario ;";

        try (Connection conexion = ConexionSingleton.getConexionSingleton().getConnection();
             Statement sentenciaSelect = conexion.createStatement();
             ResultSet resultado = sentenciaSelect.executeQuery(sqlSelect);) {
            while (resultado.next()){
                int id        = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String dni     =  resultado.getString("dni");
                System.out.printf("%d-%S-%s%n", id, nombre, dni);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        /*System.out.println("introduce id del nombre a buscar");
        int id = scanner.nextInt();
     // String nombre =  getUserNameById(id + " OR 5 == 5");
      //  System.out.printf("%d le corresponde el nombre %S%n", id, nombre);
       String nombre =  getUserNameByIdSafe(id + " OR 5 == 5");
       System.out.printf("%d le corresponde el nombre %S%n", id, nombre);*/
   //update con PreparedStatemen
        String sqlUpdate =
                "UPDATE usuario SET nombre =? WHERE id = ?;";
        try (Connection conexion = ConexionSingleton.getConexionSingleton().getConnection();
             PreparedStatement sentenciaUpdate = conexion.prepareStatement(sqlUpdate)) {
            sentenciaUpdate.setString(1, "felipe pérez");
            sentenciaUpdate.setInt(2, 5);
            int rows = sentenciaUpdate.executeUpdate();
            System.out.printf("Registros actualizados %d%n", rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static String getUserNameById (String idUser) {
        String sqlSelect = "select * from usuario where id = "
                +  idUser + ";";

        try (Connection conexion = ConexionSingleton.getConexionSingleton().getConnection();
             Statement sentenciaSelect = conexion.createStatement();
             ResultSet resultado = sentenciaSelect.executeQuery(sqlSelect);) {
            String nombre = "";
            while (resultado.next()){
                nombre = resultado.getString("nombre");
            }
            return nombre;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static String getUserNameByIdSafe (String idUser) {
        String sqlSelect = "select * from usuario where id = ? ";

        ResultSet resultado = null;
        try (Connection conexion = ConexionSingleton.getConexionSingleton().getConnection();
             PreparedStatement sentenciaSelect = conexion.prepareStatement(sqlSelect);
             ) {
             sentenciaSelect.setString(1, idUser);
             resultado = sentenciaSelect.executeQuery();
             String nombre = "";
             while (resultado.next()){
                 nombre = resultado.getString("nombre");
             }
            return nombre;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultado != null) {
                try {
                    resultado.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
