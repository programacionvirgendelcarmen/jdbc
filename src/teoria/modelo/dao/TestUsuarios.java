package teoria.modelo.dao;

import java.sql.SQLException;
import java.util.List;

public class TestUsuarios {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImp();
        try {
            System.out.println("=========CONSULTA TODOS LOS USUARIOS=========");
            List<Usuario> usuarios = usuarioDAO.obtenerTodosLosUsuario();
            usuarios.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("=========CONSULTA POR ID=========");
            Usuario usuario = usuarioDAO.obtenerUsuarioPorId(5);
            System.out.println(usuario);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Usuario newUsuario = new Usuario("gabriela gómez", "22222222k");
        try {
            System.out.println("=========INSERTAR USUARIO=========");
            boolean exitoNewUsuario = usuarioDAO.insertarUsuario(newUsuario);
            System.out.printf("Éxito de la insercción: %B%n", exitoNewUsuario);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("=========INSERTAR USUARIO=========");
            boolean exitoDelete = usuarioDAO.eliminarUsuarioPorId(8);
            System.out.printf("Éxito de la eliminación: %B%n", exitoDelete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Usuario newUser = new Usuario("luis pérez", "55555555a");
        try {
            System.out.println("=========ACTUALIZAR USUARIO=========");
            boolean exitoUpdate = usuarioDAO.actualizarUsuarioPorId(newUser, 18);
            System.out.printf("Éxito de la actualización: %B%n", exitoUpdate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
