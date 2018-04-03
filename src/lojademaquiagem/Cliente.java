
package lojademaquiagem;


public class Cliente {
    private String nome;
    private String cpf;
    private int telefone;
    private String email;
    private String endereco;
    private String cidade;

    public Cliente(String nome, String cpf, int telefone, String email, String endereco, String cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.cidade = cidade;
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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "cliente{" + "nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco + ", cidade=" + cidade + '}';
    }
    
    
    
}
