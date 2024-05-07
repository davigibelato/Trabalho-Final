/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BEAN;

/**
 *
 * @author Senai
 */
public class Produto {
    private int idProduto;
    private String nome;
    private float valor;
    private int categoria;
    private int subCategoria;
    private byte[] imagemBytes;
    private String imagemBase64;

    public Produto() {
    }

    public Produto(int idProduto, String nome, float valor, int categoria, int subCategoria, byte[] imagemBytes, String imagemBase64) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.imagemBytes = imagemBytes;
        this.imagemBase64 = imagemBase64;
    }

    

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(int subCategoria) {
        this.subCategoria = subCategoria;
    }

    public byte[] getImagemBytes() {
        return imagemBytes;
    }

    public void setImagemBytes(byte[] imagemBytes) {
        this.imagemBytes = imagemBytes;
    }

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }
    
    
}
