
package lojademaquiagem;


public class Produto {
    private int idProduto;
    private double preco;
    private int quantidadeEstoque;
    private String nomeProduto;

    public Produto(int idProduto, double preco, int quantidadeEstoque, String nome) {
        this.idProduto = idProduto;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.nomeProduto = nome;
    }

    Produto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() {
        return nomeProduto;
    }

    public void setNome(String nome) {
        this.nomeProduto = nome;
    }

    @Override
    public String toString() {
        return "produto{" + "idProduto=" + idProduto + ", preco=" + preco + ", quantidadeEstoque=" + quantidadeEstoque + ", nome=" + nomeProduto + '}';
    }
    
}
