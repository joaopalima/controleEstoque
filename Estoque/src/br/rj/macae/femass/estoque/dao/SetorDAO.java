/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.estoque.dao;



import br.rj.macae.femass.estoque.modelo.Setor;
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
public class SetorDAO implements IDAO{

    @Override
    public void adicionar(Object o) throws SQLException {
        Setor setor = (Setor) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "INSERT INTO public.setor(\n" +
"	nome)\n" +
"	VALUES (?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            stmt.setString(1, setor.getNome());
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar cadastrar a setor. \n" + e.getMessage());
        }
    }

    @Override
    public void alterar(Object o) throws SQLException {
        Setor setor = (Setor) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "UPDATE public.setor\n" +
"	SET nome=?\n" +
"	WHERE id = ?";
           /* UPDATE public.setor
	SET id=?, nome=?, descricao
	WHERE <condition>;
        */
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            stmt.setString(1, setor.getNome());
            stmt.setInt(2, setor.getId());
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar alterar a setor. \n" + e.getMessage());
        }
    }

    @Override
    public void excluir(Object o) throws SQLException {
        Setor setor = (Setor) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "DELETE FROM public.setor\n" +
"	WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores                     
            stmt.setLong(1, setor.getId());
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar remover a setor. \n" + e.getMessage());
        }
    }
    
    @Override
    public void excluir(int id) throws SQLException {
        
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "DELETE FROM public.setor\n" +
"	WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores                     
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar remover a setor. \n" + e.getMessage());
        }
    }

    @Override
    public List listarTodos() throws SQLException{
        List lista = new ArrayList();
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();
            String sql = "SELECT id, nome\n" +
"	FROM public.setor ORDER BY id ASC;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Setor c = new Setor("");
                c.setNome(rs.getString("nome"));              
                c.setId(rs.getInt("id"));
                
                lista.add(c);
            }

            rs.close();
            stmt.close();
            
            return lista;
        } catch (SQLException e) {
            throw new SQLException("Eroo ao recuperar a lista de setors. \n" + e.getMessage());
        }
    }

    @Override
    public Object listarPorId(int id) throws SQLException {
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();
            String sql = "SELECT id, nome\n" +
"	FROM public.setor WHERE id=?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Setor c = new Setor("");
            c.setNome(rs.getString("nome"));              
            c.setId(rs.getInt("id"));
            

            rs.close();
            stmt.close();
            
            return c;
        } catch (SQLException e) {
            throw new SQLException("Erro ao recuperar a setor. \n" + e.getMessage());
        }
    }
    
}
