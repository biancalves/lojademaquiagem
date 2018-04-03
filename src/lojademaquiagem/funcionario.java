
package lojademaquiagem;

import java.util.logging.Logger;


public class funcionario {
    private String nome;
    private String cpf;
    private int codFuncionario;
    private String telefone;
    private String email;

    public funcionario(String nome, String cpf, int codFuncionario, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.codFuncionario = codFuncionario;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "funcionario{" + "nome=" + nome + ", cpf=" + cpf + ", codFuncionario=" + codFuncionario + ", telefone=" + telefone + ", email=" + email + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
  
    
}
