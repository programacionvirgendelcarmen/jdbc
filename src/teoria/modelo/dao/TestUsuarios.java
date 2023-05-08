package teoria.modelo.dao;

import java.sql.SQLException;
import java.util.List;

public class TestUsuarios {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImp();
        try {
            List<Usuario> usuarios = usuarioDAO.obtenerTodosLosUsuario();
            usuarios.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
