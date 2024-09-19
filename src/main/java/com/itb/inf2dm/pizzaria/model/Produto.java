package com.itb.inf2dm.pizzaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Produto")
public class Produto {

    // Para prover o encapsulamento temos que seguir alguns passos:
    // 1º ) Trabalhar os modificadores de acesso dos atributos: public -> private ou public -> protected
    // Modificadores de acesso:

    // public :   Acesso livre para todas as classes
    // private:   Acesso livre "apenas" dentro da classe
    // protected: Acesso livre apenas para as classes filhas (sistema de herança)

    //2º ) Criar os métodos setter´s e getter´s para cada um dos atributos
    // Obs: cada atributo criamos o set e o get correspondente, na maioria dos casos.
    //  set -> atribuir valor
    //  get -> recuperar valor

    // 3º) Enfim, criar os métodos de validação, onde eu posso trabalhar regras bem definidas

    @Id                                                        // Representa a PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)        // AUTO-INCREMENT
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = true, length = 45)
    private String tipo;
    @Column(nullable = true, length = 250)
    private String descricao;
    @Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
    private double valorCompra;
    @Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
    private double valorVenda;
    @Column(nullable = true)
    private int quantidadeEstoque;
    private boolean codStatus;

    // atributos de apoio

    @Transient                             // ATRIBUTOS QUE NÃO CORRESPONDEM A UMA COLUNA DE BANCO DE DADOS
    @JsonIgnore
    private String mensagemErro = "";
    @Transient
    @JsonIgnore
    private boolean isValid = true;


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public boolean isCodStatus() {
        return codStatus;
    }

    public void setCodStatus(boolean codStatus) {
        this.codStatus = codStatus;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }


    // Método para validar o produto

    public boolean validarProduto() {
        if(valorVenda < 0) {
            isValid = false;
            valorVenda = 0;
            mensagemErro += "O preço de venda não pode ser menor que zero:";
        }
        if(valorCompra < 0) {
            isValid = false;
            valorCompra = 0;
            mensagemErro += "O preço de compra não pode ser menor que zero:";
        }
        return isValid;
    }


}
