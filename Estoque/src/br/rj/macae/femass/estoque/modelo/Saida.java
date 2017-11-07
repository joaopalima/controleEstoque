/*
 * To change this license header, choprodutose License Headers in Project Properties.
 * To change this template file, choprodutose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.estoque.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jorge
 */
public class Saida {
    
    private Integer id;
    private String data;
    private String comentario;
    private Empregado empregado;
    private Produto produto;
    private List<Saida_Produto> produtos;
    

    public Saida(Integer id) {
        this.id = id;
        produtos = new ArrayList<Saida_Produto>();
    }
    
    public Saida() {
        produtos = new ArrayList<Saida_Produto>();
    }
    
        
    public List<Saida_Produto> getProduto(){
        return Collections.unmodifiableList(produtos);
    }
    public void setProduto(Saida_Produto produto){
        this.produtos.add(produto);
    }
    public void removeProduto(Saida_Produto produto){
        if(this.produtos.contains(produto))
            this.produtos.remove(produto);
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
        
    }

    

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Saida other = (Saida) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+id ;
    }
    
    
    
    
}
