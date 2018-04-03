
package lojademaquiagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClienteDAO {
    
    public void create(Cliente cliente) {

        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT MAX(cpf) FROM produto",
                sql2 = "INSERT INTO cpf VALUES(?,?,?,?,?,?)";

                ResultSet rs = null;
                int cpf = 0;
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                rs = stmt1.executeQuery();
                
                if(rs.next()){
                    cpf = rs.getInt("max") + 1;
                }
                else
                {
                    cpf = 1;
                }
                
                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                stmt2.setInt(1, cpf);
                stmt2.setString(2, cliente.getNome());
                stmt2.setInt(3, cliente.getTelefone());
                stmt2.setString(4,cliente.getEmail());
                stmt2.setString(5,cliente.getEndereco());
                stmt2.setString(6,cliente.getCidade());
                stmt2.execute();
          
            }
        });
    }
    public void update(Cliente cliente) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "UPDATE CLIENTE SET nome = ?, telefone = ?, email = ?, endereco = ?, cidade = ? , WHERE cpf = ?";
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setString(1, cliente.getNome());
                stmt1.setInt(2, cliente.getTelefone());
                stmt1.setString(3,cliente.getEmail());
                stmt1.setString(4,cliente.getEndereco());
                stmt1.setString(5,cliente.getCidade());
                stmt1.setString(6,cliente.getCpf());
                
            }
        });
    }
    public void delete(Cliente cliente) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "DELETE FROM CLIENTE WHERE cpf = ?";
                
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setString(1, cliente.getCpf());
                stmt1.execute();
                
            }
        });
    }
        
    public Cliente read(String cpf) {
        Cliente cli = new Cliente();
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT * FROM cliente WHERE cpf = ?";
                ResultSet rs = null;

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setString(1, cpf);
                rs = stmt1.executeQuery();

                if (rs.next()) {
                    cli.setCpf(cpf);
                    cli.setNome(rs.getString("nome"));
                    cli.setTelefone(rs.getInt("telefone"));
                    cli.setEmail(rs.getString("email"));
                    cli.setEndereco(rs.getString("endereco"));
                    cli.setCidade(rs.getString("cidade"));
                }

            }
        });
        return cli;
    }
}
    
