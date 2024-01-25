package com.titan.software.api;

import java.util.List;

public class ListaVendas {
    private String itens;
    private int paginas;
    private List<Vendas> data;

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        this.itens = itens;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public List<Vendas> getData() {
        return data;
    }

    public void setData(List<Vendas> data) {
        this.data = data;
    }
}
