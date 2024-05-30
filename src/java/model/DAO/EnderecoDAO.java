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
import java.sql.Statement;

import model.BEAN.Endereco;

/**
 *
 * @author Davi
 */
public class EnderecoDAO {

    public boolean inserirEndereco(Endereco e) {
        String sql = "INSERT INTO endereco (estado, cidade, cep, rua, numero, complemento) VALUES (?,?,?,?,?,?)";

        try (Connection conexao = Conexao.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, e.getEstado());
            stmt.setString(2, e.getCidade());
            stmt.setInt(3, e.getCep());
            stmt.setString(4, e.getRua());
            stmt.setInt(5, e.getNumeroCasa());
            stmt.setString(6, e.getComplemento());

            int aR = stmt.executeUpdate();

            //Verifica se tem algum insert no banco
            // Verifica se a instrução SQL de inserção afetou alguma linha.
            if (aR > 0) {
                // Bloco try-with-resources para garantir o fechamento automático do ResultSet.
                try (ResultSet pegarChave = stmt.getGeneratedKeys()) {

                    // Verifica se há uma chave gerada disponível.
                    if (pegarChave.next()) {
                        // Obtém o valor da chave gerada a partir do ResultSet.
                        int id = pegarChave.getInt(1);

                        // Define o ID atual do endereço usando o valor obtido.
                        Endereco.setIdEndereçoAtual(id);
                    }
                }
            }

            return true;

        } catch (SQLException ed) {
            ed.printStackTrace();
            return false;
        }
    }

}
