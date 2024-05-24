package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.BEAN.Usuario;

public class UsuarioDAO {

    public Usuario login(Usuario user) {
        Usuario usuarioValido = new Usuario();
        try {
            Connection con = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ?");
            //PEGA O ID DO USUARIO E AS INFORMAÇÕES EMAIL E SENHA
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();
            //EXECUTE O SELECT

            if (rs.next()) {
                usuarioValido.setIdUsuario(rs.getInt("idUsuario"));
                usuarioValido.setEmail(rs.getString("email"));
                usuarioValido.setSenha(rs.getString("senha"));
            }
            
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            usuarioValido.setIdUsuario(0);
            //SE NÃO EXECUTAR DEFINE O ID DO USUARIO COMO 0
        }
        return usuarioValido;
    }

    public void create(Usuario u) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO usuario (nome, email, senha, cpf, telefone, data_registro) values (?, ?, ?, ?, ?, current_timestamp)");
            //FAZ UMA CRIAÇÃO DE DADOS NA TABELA USUARIO
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getCpf());
            stmt.setString(5, u.getTelefone());
            
            stmt.executeUpdate();
            //EXECUTA A INSERÇÃO
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Usuario u) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ?, cpf = ?, telefone = ?, status = ? WHERE idUsuario = ?");
            //ATUALIZA AS INFORMAÇÕES DO USUARIO COM BASE NO ID DELE
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getCpf());
            stmt.setString(5, u.getTelefone());
            stmt.setString(6, u.getStatus());
            stmt.setInt(7, u.getIdUsuario());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(Usuario u) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");
            //DELETA O USUARIO DE ACORDO COM ID DELE
            stmt.setInt(1, u.getIdUsuario());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
