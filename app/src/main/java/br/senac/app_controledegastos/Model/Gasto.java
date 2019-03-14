package br.senac.app_controledegastos.Model;

import java.io.Serializable;

import br.senac.app_controledegastos.adapters.GastoAdapter;

public class Gasto implements Serializable {

    private long idGasto;
    private String data;
    private String descricao;
//    private String categoria;
    private double valor;

    public Gasto(long idGasto, String data, String descricao, double valor) {
        this.idGasto = idGasto;
        this.data = data;
        this.descricao = descricao;
//        this.categoria = categoria;
        this.valor = valor;
    }

    public Gasto(String data, String descricao, double valor) {
        this.data = data;
        this.descricao = descricao;
//        this.categoria = categoria;
        this.valor = valor;
    }

    public Gasto(GastoAdapter gastoAdapter) {
    }

    @Override
    public String toString() {
        return ("Data: " + data + "\n" +
                "Descrição: " + descricao + "\n" +
//                "Categoria: " + categoria + "\n" +
                "Valor: " + valor);
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

//    public String getCategoria() { return categoria;}

    public double getValor() {
        return valor;
    }

    public void setIdGasto(long idGasto) {this.idGasto = idGasto;}

    public void setData(String data) {this.data = data;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

//    public void setCategoria(String categoria) {this.categoria = categoria;}

    public void setValor(double valor) {this.valor = valor;}

    
}
