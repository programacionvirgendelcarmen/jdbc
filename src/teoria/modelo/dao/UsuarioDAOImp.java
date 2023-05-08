package teoria.modelo.dao;

import teoria.conexion.ConexionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImp implements UsuarioDAO{
    private static final Connection conexion;

    static {
        try {
            conexion = ConexionSingleton.getConexionSingleton().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insertarUsuario(Usuario usuario) {
        return false;
    }

    @Override
    public boolean eliminarUsuarioPorId(int id) {
        return false;
    }

    @Override
    public boolean actualizarUsuarioPorId(Usuario newUsuario, int id) {
        return false;
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        return null;
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuario() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "select * from usuario;";
        Statement sentencia = conexion.createStatement();
        ResultSet resultado = sentencia.executeQuery(sql);
        while (resultado.next()){
            int id        = resultado.getInt("id");
            String nombre = resultado.getString("nombre");
            String dni    = resultado.getString("dni");
            Usuario usuario = new Usuario(id, nombre, dni);
            usuarios.add(usuario);
        }
        if (resultado != null)
            resultado.close();
        if (sentencia != null)
            sentencia.close();

        return usuarios;
    }
}
