package br.devmobile_control.Model;
import java.io.Serializable;
import br.devmobile_control.adapters.GastoAdapter;

public class Gasto implements Serializable {

    private long idGasto;
    private String data;
    private String descricao;
    private String categoria;
    private double valor;
    public static double GASTO_TOTAL; //atributo static são de classe

    public Gasto(long idGasto, String data, String descricao, String categoria, double valor) {
        this.idGasto = idGasto;
        this.data = data;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        GASTO_TOTAL += valor;    }

    public Gasto(String data, String descricao, String categoria, double valor) {
        this.data = data;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        GASTO_TOTAL += valor;
    }



    @Override
    public String toString() {
        return ("Data: " + data + "\n" +
                "Descrição: " + descricao + "\n" +
                "Categoria: " + categoria + "\n" +
                "Valor: " + valor + "," + valor);
    }

    public long getIdGasto() {
        return idGasto;
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() { return categoria;}

    public double getValor() {
        return valor;
    }

    public void setIdGasto(long idGasto) {this.idGasto = idGasto;}

    public void setData(String data) {this.data = data;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public void setCategoria(String categoria) {this.categoria = categoria;}

    public void setValor(double valor) {
        this.valor = valor;
    }

    
}
