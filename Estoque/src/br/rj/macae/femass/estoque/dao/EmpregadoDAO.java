/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.estoque.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anamm
 */
public class EmpregadoDAO implements IDAO{

    @Override
    public void adicionar(Object o) throws SQLException {
        Empregado empregado = (Empregado) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "INSERT INTO public.empregado(\n" +
"	nome)\n" +
"	VALUES (?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            stmt.setString(1, empregado.getNome());
            
            
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar cadastrar a empregado. \n" + e.getMessage());
        }
    }

    @Override
    public void alterar(Object o) throws SQLException {
        Empregado empregado = (Empregado) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "UPDATE public.empregado\n" +
"	SET nome=?\n" +
"	WHERE id = ?";
           /* UPDATE public.empregado
	SET id=?, nome=?, descricao
	WHERE <condition>;
        */
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            stmt.setString(1, empregado.getNome());
            
            stmt.setInt(2, empregado.getId());
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar alterar a empregado. \n" + e.getMessage());
        }
    }

    @Override
    public void excluir(Object o) throws SQLException {
        Empregado empregado = (Empregado) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "DELETE FROM public.empregado\n" +
"	WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores                     
            stmt.setLong(1, empregado.getId());
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar remover a empregado. \n" + e.getMessage());
        }
    }
    
    @Override
    public void excluir(int id) throws SQLException {
        
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "DELETE FROM public.empregado\n" +
"	WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores                     
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar remover a empregado. \n" + e.getMessage());
        }
    }

    @Override
    public List listarTodos() throws SQLException{
        List lista = new ArrayList();
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();
            String sql = "SELECT id, nome\n" +
"	FROM public.empregado ORDER BY id ASC;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Empregado c = new Empregado("");
                c.setNome(rs.getString("nome"));              
                c.setId(rs.getInt("id"));
                
                lista.add(c);
            }

            rs.close();
            stmt.close();
            
            return lista;
        } catch (SQLException e) {
            throw new SQLException("Eroo ao recuperar a lista de empregados. \n" + e.getMessage());
        }
    }

    @Override
    public Object listarPorId(int id) throws SQLException {
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();
            String sql = "SELECT id, nome\n" +
"	FROM public.empregado WHERE id=?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Empregado c = new Empregado("");
            c.setNome(rs.getString("nome"));              
            c.setId(rs.getInt("id"));
            

            rs.close();
            stmt.close();
            
            return c;
        } catch (SQLException e) {
            throw new SQLException("Erro ao recuperar a empregado. \n" + e.getMessage());
        }
    }
    
}
