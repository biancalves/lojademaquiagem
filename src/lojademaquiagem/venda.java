
package lojademaquiagem;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.sql.Time;
import java.util.Date;


public class Venda {
    private int idVenda;
    private Cliente cli;
    private Funcionario Func;
    private Date data;
    private Time hora;
    private int valorVenda;

    public Venda(int idVenda, Cliente cli, Funcionario Func, Date data,
            Time hora, int valorVenda) {
        this.idVenda = idVenda;
        this.cli = cli;
        this.Func = Func;
        this.data = data;
        this.hora = hora;
        this.valorVenda = valorVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Funcionario getFunc() {
        return Func;
    }

    public void setFunc(Funcionario Func) {
        this.Func = Func;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(int valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Override
    public String toString() {
        return "venda{" + "idVenda=" + idVenda
                + ", cli=" + cli + ", Func=" + Func
                + ", data=" + data + ", hora=" + hora
                + ", valorVenda=" + valorVenda + '}';
    }
}






