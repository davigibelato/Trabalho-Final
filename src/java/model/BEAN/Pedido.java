/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BEAN;

import java.sql.Timestamp;

/**
 *
 * @author Davi
 */
public class Pedido {
    private int idPedido;
    private int usuario;
    private int endereco_entrega;
    private String formaDePagamento;
    private static String formaDePagamentoStatic;
    private String status_pedido;
    private Timestamp data_registro; // Adicionando campo data_registro
    private float valorTotal;
    private int valorFrete;
    
    public Pedido() {
    }

    public static String getFormaDePagamentoStatic() {
        return formaDePagamentoStatic;
    }

    public static void setFormaDePagamentoStatic(String formaDePagamentoStatic) {
        Pedido.formaDePagamentoStatic = formaDePagamentoStatic;
    }
    
    

    public Pedido(int idPedido, int usuario, int endereco_entrega, String formaDePagamento, String status_pedido) {
        this.idPedido = idPedido;
        this.usuario = usuario;
        this.endereco_entrega = endereco_entrega;
        this.formaDePagamento = formaDePagamento;
        this.status_pedido = status_pedido;
        
    }

    public int getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(int valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Pedido(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pedido(Timestamp data_registro) {
        this.data_registro = data_registro;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getEndereco_entrega() {
        return endereco_entrega;
    }

    public void setEndereco_entrega(int endereco_entrega) {
        this.endereco_entrega = endereco_entrega;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public String getStatus_pedido() {
        return status_pedido;
    }

    public void setStatus_pedido(String status_pedido) {
        this.status_pedido = status_pedido;
    }

    public Timestamp getData_registro() {
        return data_registro;
    }

    public void setData_registro(Timestamp data_registro) {
        this.data_registro = data_registro;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
            
}
