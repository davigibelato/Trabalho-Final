/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.BEAN.Usuario;

/**
 *
 * @author Senai
 */
public class UsuarioDAO {

    public Usuario login(Usuario user) {
        Usuario usuarioValido = new Usuario();
        try {
            Connection con = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();

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
            usuarioValido.setEmail("");
            usuarioValido.setSenha("");
        }
        return usuarioValido;
    }

    public void create(Usuario u) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO usuario (nome, email, senha, cpf, telefone, status) values (?, ?, ?, ?, ?,?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getCpf());
            stmt.setString(5, u.getTelefone());
            stmt.setInt(6, u.getStatus());

            stmt.executeUpdate();
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
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getCpf());
            stmt.setString(5, u.getTelefone());
            stmt.setInt(6, u.getStatus());
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

            stmt = conexao.prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ?, cpf = ?, telefone = ? WHERE idUsuario = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, "");
            stmt.setString(4, u.getCpf());
            stmt.setString(5, u.getTelefone());
            stmt.setInt(6, u.getStatus());
            stmt.setInt(7, u.getIdUsuario());

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
