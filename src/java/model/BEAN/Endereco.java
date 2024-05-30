/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BEAN;

/**
 *
 * @author Davi
 */
public class Endereco {
    private int idEndereço;
    private static int idEndereçoAtual;
    private String estado;
    private String cidade;
    private int cep;
    private String rua;
    private int numeroCasa;
    private String complemento;

    public Endereco() {
    }

    public Endereco(int idEndereço, String estado, String cidade, int cep, String rua, int numeroCasa, String complemento) {
        this.idEndereço = idEndereço;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
    }

    public static int getIdEndereçoAtual() {
        return idEndereçoAtual;
    }

    public static void setIdEndereçoAtual(int idEndereçoAtual) {
        Endereco.idEndereçoAtual = idEndereçoAtual;
    }

    
    public int getIdEndereço() {
        return idEndereço;
    }

    public void setIdEndereço(int idEndereço) {
        this.idEndereço = idEndereço;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
}
