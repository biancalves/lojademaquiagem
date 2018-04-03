
package lojademaquiagem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import static javax.swing.UIManager.getString;

public class cadastroLoja {
     
    
    public void adicionarCliente(Cliente cli) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO cliente(nome,cpf ,telefone, email, endereco, cidade ) VALUES(?,?,?,?,?,?)");
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getCpf());
            stmt.setInt(3, cli.getTelefone());
            stmt.setString(4, cli.getEmail());
            stmt.setString(5, cli.getEndereco());
            stmt.setString(6, cli.getCidade());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    
    public void adicionarFuncionario(funcionario func) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO cliente(nome,cpf ,cod_funcionario, telefone, email ) VALUES(?,?,?,?,?)");
            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getCpf());
            stmt.setInt(3, func.getCodFuncionario() );
            stmt.setString(4, func.getTelefone());
            stmt.setString(5, func.getEmail());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    public void adicionarProduto(Produto pro) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO cliente(id_produto, preço ,quantidade_estoque,  nome_produto ) VALUES(?,?,?,?,)");
            stmt.setInt(1, pro.getIdProduto());
            stmt.setInt(2, pro.getPreco());
            stmt.setInt(3, pro.getQuantidadeEstoque());
            stmt.setString(4, pro.getNome());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    public void adicionarVenda(venda v) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO cliente(id_venda , nome_cliente, nome_funcionario ,data, hora,valor_venda ,id_funcionario ,cpf_cliente  ) VALUES(?,?,?,?,?,?,?,?)");
            stmt.setInt(1, v.getIdVenda());
            stmt.setString(2, v.getCli().getNome());
            stmt.setString(3, v.getFunc().getNome());
            stmt.setDate(4, (Date) v.getData());
            stmt.setTime(5, v.getHora());
            stmt.setInt(6,v.getValorVenda());
            stmt.setInt(7, v.getIdFuncionario());
            stmt.setString(8, v.getCpfCliente());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    public void adicionarItemVenda(itemVenda iv) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO cliente(id_produto, nome_produto ,quantidade_venda  ) VALUES(?,?,?)");
            stmt.setInt(1, iv.getPro().getIdProduto());
            stmt.setString(2, iv.getPro().getNome());
            stmt.setInt(3, iv.getQuantidadeVenda());
           

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    
    
    public List<Produto> listarProduto() {
        List<Produto> listaRetorno = new LinkedList<>();

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM produto ORDER BY id_produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto pro = new Produto(rs.getInt("id_produto"),
                        rs.getInt("preço"), rs.getInt("quantidade_estoque "), rs.getString("nome_produto"));
                listaRetorno.add(pro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }

        return listaRetorno;
    }
    public List<Cliente> listarCliente() {
        List<Cliente> listaRetorno = new LinkedList<>();

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM cliente ORDER BY cpf");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cli = new Cliente(rs.getString("cpf"),rs.getString("nome"), rs.getInt("telefone") , rs.getString("email"), rs.getString("endereco"),rs.getString("cidade"));
                listaRetorno.add(cli);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }

        return listaRetorno;
    }
    
}
