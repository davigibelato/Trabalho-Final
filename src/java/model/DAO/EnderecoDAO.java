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
import model.BEAN.Usuario;

/**
 *
 * @author Davi
 */
public class EnderecoDAO {

    public boolean inserirEndereco(Endereco e) {
        String sql = "INSERT INTO endereco (estado, cidade, cep, rua, numero, complemento,usuario) VALUES (?,?,?,?,?,?,?)";

        try (Connection conexao = Conexao.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, e.getEstado());
            stmt.setString(2, e.getCidade());
            stmt.setInt(3, e.getCep());
            stmt.setString(4, e.getRua());
            stmt.setInt(5, e.getNumeroCasa());
            stmt.setString(6, e.getComplemento());
            stmt.setInt(7, e.getUsuario());
            
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
                        Endereco.setIdEnderecoAtual(id);
                        System.out.println("Id do endereço: "+id);
                    }
                }
            }

            return true;

        } catch (SQLException ed) {
            ed.printStackTrace();
            return false;
        }
    }
    
    public Endereco mostrarCheckout(){
        
        Endereco e = new Endereco();        
        
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("SELECT rua, cep, idEndereco FROM endereco WHERE usuario = ?");
            ResultSet rs = null;
            
            stmt.setInt(1, Usuario.getIdUsuario());
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                e.setRua(rs.getString("rua"));
                e.setCep(rs.getInt("cep"));
                Endereco.setIdEnderecoAtual(rs.getInt("idEndereco"));
            }
            
            rs.close();
            stmt.close();
            conexao.close();           
            
            }catch(SQLException ed){
                ed.printStackTrace();
            
        }
        
        return e;
    }

}
