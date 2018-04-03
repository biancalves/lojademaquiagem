/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojademaquiagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author ALUNO
 */
public class ProtudoDAO {

    public void create(Produto produto) {

        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT MAX(id_produto) FROM produto",
                sql2 = "INSERT INTO produto VALUES(?,?,?,?)";

                ResultSet rs = null;
                int id = 0;
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                rs = stmt1.executeQuery();
                
                if(rs.next()){
                    id = rs.getInt("max") + 1;
                }
                else
                {
                    id = 1;
                }
                
                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                stmt2.setInt(1, id);
                stmt2.setDouble(2, produto.getPreco());
                stmt2.setInt(3, produto.getQuantidadeEstoque());
                stmt2.setString(4,produto.getNome());
                stmt2.execute();
          
            }
        });
    }
    public void update(Produto produto) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "UPDATE PRODUTO SET preco = ?, quantidade_estoque = ?, nome_produto = ? WHERE id_produto = ?";
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setDouble(1, produto.getPreco());
                stmt1.setInt(2, produto.getQuantidadeEstoque());
                stmt1.setString(3,produto.getNome());
                stmt1.setInt(4, produto.getIdProduto());
                stmt1.executeUpdate();
                
            }
        });
        
    }
    
    public void delete(Produto produto) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "DELETE FROM PRODUTO WHERE id_produto = ?";
                
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, produto.getIdProduto());
                stmt1.execute();
                
            }
        });
    }
    
    public Produto read(int id) {
        Produto prod = new Produto();
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT * FROM produto WHERE id_produto = ?";
                ResultSet rs = null;
                
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, id);
                rs = stmt1.executeQuery();
                
                if(rs.next()){
                    prod.setIdProduto(id);
                    prod.setNome(rs.getString("nome_produto"));
                    prod.setPreco(rs.getDouble("preco"));
                    prod.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
                }
                
            }
        });
        return prod;
    }
    
    public ArrayList<Produto> listAll() {
        ArrayList<Produto> prods = new ArrayList<>();
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT * FROM produto";
                ResultSet rs = null;
                
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                rs = stmt1.executeQuery();
                
                while(rs.next()){
                    prods.add(new Produto(rs.getInt("id_produto"), rs.getDouble("preco"), rs.getInt("quantidade_estoque"), rs.getString("nome_produto")));
                }
            }
        });
        return prods;
    }
    
    
}




