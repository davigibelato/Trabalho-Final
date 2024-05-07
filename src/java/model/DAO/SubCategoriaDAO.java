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
import java.util.ArrayList;
import java.util.List;
import model.BEAN.Categoria;
import model.BEAN.SubCategoria;

/**
 *
 * @author Senai
 */
public class SubCategoriaDAO {
    public List<SubCategoria> listarTodos(){
        List<SubCategoria> categorias = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM subCategoria");

            rs = stmt.executeQuery();

            while (rs.next()) {
                SubCategoria c = new SubCategoria();
                c.setIdSubCategoria(rs.getInt("idSubCategoria"));
                c.setNome(rs.getString("nome"));
                c.setIdCategoria(rs.getInt("idCategoria"));
                categorias.add(c);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return categorias;
    }
    
    private SubCategoria readById(int id) {
        SubCategoria c = new SubCategoria();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM SubCcategoria WHERE idSubCategoria = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                c.setIdSubCategoria(id);
                c.setNome(rs.getString("nome"));
                c.setIdCategoria(rs.getInt("idCategoria"));
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    private SubCategoria readByNome(String nome) {
        SubCategoria c = new SubCategoria();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM SubCategoria WHERE nome = ?");
            stmt.setString(1, c.getNome());

            rs = stmt.executeQuery();

            if (rs.next()) {
                c.setIdSubCategoria(rs.getInt("idSubCategoria"));
                c.setNome(nome);
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    private SubCategoria readByNome(SubCategoria c) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM SubCategoria WHERE nome = ?");
            stmt.setString(1, c.getNome());

            rs = stmt.executeQuery();

            if (rs.next()) {
                c.setIdSubCategoria(rs.getInt("idSubCategoria"));
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
}
