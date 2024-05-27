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
public class Carrinho {
   private int idCarrinho;
   private int usuario;
   private int produto;
   private int quantidade;
   private float subProduto;
   private float subTotal;
   private String nomeProduto;
   private Float valorProduto;
   private byte[] imagemBytes;
   private String imagemBase64;

    public Carrinho() {
    }

    public Carrinho(int idCarrinho, int usuario, int produto, int quantidade, float subProduto, float subTotal, String nomeProduto, Float valorProduto, byte[] imagemBytes, String imagemBase64) {
        this.idCarrinho = idCarrinho;
        this.usuario = usuario;
        this.produto = produto;
        this.quantidade = quantidade;
        this.subProduto = subProduto;
        this.subTotal = subTotal;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.imagemBytes = imagemBytes;
        this.imagemBase64 = imagemBase64;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getSubProduto() {
        return subProduto;
    }

    public void setSubProduto(float subProduto) {
        this.subProduto = subProduto;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Float valorProduto) {
        this.valorProduto = valorProduto;
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
