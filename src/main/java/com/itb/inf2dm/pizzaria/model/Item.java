package com.itb.inf2dm.pizzaria.model;

public class Item {

    private Long id;
    private int quantidadeItem;
    private double valorUnitario;

    // atributos de apoio

    private String mensagemErro = "";
    private boolean isValid = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(int quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public boolean validarItem() {

        return isValid;
    }
}
