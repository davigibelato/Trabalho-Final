/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BEAN;


public class Categoria {
    private int idCategoria;
    private String nome;
    private static int idStaticoCategoria;

    public Categoria() {
    }

    public Categoria(int idCategoria, String nome) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        
    }

    public static int getIdStaticoCategoria() {
        return idStaticoCategoria;
    }

    public static void setIdStaticoCategoria(int idStaticoCategoria) {
        Categoria.idStaticoCategoria = idStaticoCategoria;
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
