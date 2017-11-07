/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.estoque.modelo;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.swing.JList;

/**
 *
 * @author jorge
 */
public class Saida_Produto {
    
    private Saida saida;
    private Produto produto;
    private float quantidade;
    private String unidade;

    public Saida getSaida() {
        return saida;
    }

    public void setSaida(Saida saida) {
        this.saida = saida;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Saida_Produto other = (Saida_Produto) obj;
        if (Float.floatToIntBits(this.quantidade) != Float.floatToIntBits(other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.unidade, other.unidade)) {
            return false;
        }
        if (!Objects.equals(this.saida, other.saida)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return produto+" | "+quantidade+" "+unidade.toUpperCase() ;
    }   
     
}
