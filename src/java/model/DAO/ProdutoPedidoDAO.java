/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.BEAN.ProdutoPedido;
import model.BEAN.Usuario;

/**
 *
 * @author Senai
 */
public class ProdutoPedidoDAO {
        
   public boolean inserirProduto(int idPedido) {
    String insertSql = "INSERT INTO produto_pedido (pedido, produto, quantidade) " +
                       "SELECT ?, produto, quantidade " +
                       "FROM carrinho " +
                       "WHERE usuario = ?";
                       
    String deleteSql = "DELETE FROM carrinho WHERE usuario = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement insertStmt = conn.prepareStatement(insertSql);
         PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {

        conn.setAutoCommit(false); // Inicia a transação

        // Configura os parâmetros para a inserção
        insertStmt.setInt(1, idPedido);
        insertStmt.setInt(2, Usuario.getIdUsuario());
        insertStmt.executeUpdate();

        // Configura os parâmetros para a exclusão
        deleteStmt.setInt(1, Usuario.getIdUsuario());
        deleteStmt.executeUpdate();

        conn.commit(); // Confirma a transação

        return true;

    } catch (SQLException e) {
        e.printStackTrace();
       
        return false;
    }
}
}
