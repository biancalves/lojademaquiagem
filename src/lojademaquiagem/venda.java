
package lojademaquiagem;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.sql.Time;
import java.util.Date;


public class venda {
    private int idVenda;
    private Cliente cli;
    private funcionario Func;
    private Date data= new Date();
    private Time hora;
    private int valorVenda;
    private int idFuncionario;
    private String cpfCliente;

    public venda(int idVenda, Cliente cli, funcionario Func, Time hora, int valorVenda, int idFuncionario, String cpfCliente) {
        this.idVenda = idVenda;
        this.cli = cli;
        this.Func = Func;
        this.hora = hora;
        this.valorVenda = valorVenda;
        this.idFuncionario = idFuncionario;
        this.cpfCliente = cpfCliente;
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

    public funcionario getFunc() {
        return Func;
    }

    public void setFunc(funcionario Func) {
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

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    @Override
    public String toString() {
        return "venda{" + "idVenda=" + idVenda + ", cli=" + cli + ", Func=" + Func + ", data=" + data + ", hora=" + hora + ", valorVenda=" + valorVenda + ", idFuncionario=" + idFuncionario + ", cpfCliente=" + cpfCliente + '}';
    }

  
    
            
}






