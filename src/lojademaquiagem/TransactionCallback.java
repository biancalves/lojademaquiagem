/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojademaquiagem;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ALUNO
 */
public interface TransactionCallback {
    
    public void execute(Connection connection) throws SQLException;
}
