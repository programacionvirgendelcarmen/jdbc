package teoria.modelo.dao;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    boolean insertarUsuario(Usuario usuario);
    boolean eliminarUsuarioPorId(int id);
    boolean actualizarUsuarioPorId(Usuario newUsuario, int id);
    Usuario obtenerUsuarioPorId(int id);
    List<Usuario> obtenerTodosLosUsuario() throws SQLException;
}
