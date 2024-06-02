package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.BEAN.Pedido;
import model.BEAN.Usuario;

public class PedidoDAO {

    public boolean inserir(Pedido pedido) {
        String sql = "INSERT INTO pedido (usuario, endereco_entrega, valorTotal, data_pedido) VALUES (?, ?, ?, current_timestamp)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedido.getUsuario());
            stmt.setInt(2, pedido.getEndereco_entrega());
            stmt.setFloat(3, pedido.getValorTotal());
            
            stmt.executeUpdate();
            
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizar(Pedido pedido) {
        String sql = "UPDATE pedido SET usuario = ?, endereco_entrega = ?, formaDePagamento = ?, status_pedido = ? WHERE idPedido = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedido.getUsuario());
            stmt.setInt(2, pedido.getEndereco_entrega());
            stmt.setString(3, pedido.getFormaDePagamento());
            stmt.setString(4, pedido.getStatus_pedido());
            stmt.setInt(5, pedido.getIdPedido());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(int idPedido) {
        String sql = "DELETE FROM pedido WHERE idPedido = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPedido);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Pedido obterPorId(int idPedido) {
        String sql = "SELECT * FROM pedido WHERE idPedido = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPedido);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setUsuario(rs.getInt("usuario"));
                pedido.setEndereco_entrega(rs.getInt("endereco_entrega"));
                pedido.setFormaDePagamento(rs.getString("formaDePagamento"));
                pedido.setStatus_pedido(rs.getString("status_pedido"));
                pedido.setData_registro(rs.getTimestamp("data_pedido"));
                return pedido;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Pedido> obterTodos() {
        String sql = "SELECT * FROM pedido";
        List<Pedido> pedidos = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setUsuario(rs.getInt("usuario"));
                pedido.setEndereco_entrega(rs.getInt("endereco_entrega"));
                pedido.setFormaDePagamento(rs.getString("formaDePagamento"));
                pedido.setStatus_pedido(rs.getString("status_pedido"));
                pedido.setData_registro(rs.getTimestamp("data_pedido"));
                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }
}
