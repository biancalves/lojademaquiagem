
package lojademaquiagem;


public class itemVenda {
    private Produto Pro;
    private int quantidadeVenda;

    public itemVenda(Produto Pro, int quantidadeVenda) {
        this.Pro = Pro;
        this.quantidadeVenda = quantidadeVenda;
    }

    public Produto getPro() {
        return Pro;
    }

    public void setPro(Produto Pro) {
        this.Pro = Pro;
    }

    public int getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public void setQuantidadeVenda(int quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }
    
}
