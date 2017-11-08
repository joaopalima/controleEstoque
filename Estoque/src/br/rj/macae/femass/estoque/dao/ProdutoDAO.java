/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.estoque.dao;



import br.rj.macae.femass.estoque.modelo.Produto;
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
public class ProdutoDAO implements IDAO{

    @Override
    public void adicionar(Object o) throws SQLException {
        Produto produto = (Produto) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "INSERT INTO public.produto(\n" +
"	nome,  modelo)\n" +
"	VALUES (?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getModelo());

            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar cadastrar a produto. \n" + e.getMessage());
        }
    }

    @Override
    public void alterar(Object o) throws SQLException {
        Produto produto = (Produto) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "UPDATE public.produto\n" +
"	SET nome=?,  modelo=?\n" +
"	WHERE id = ?";
           /* UPDATE public.produto
	SET id=?, nome=?
	WHERE <condition>;
        */
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getModelo());
            stmt.setInt(3, produto.getId());
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar alterar a produto. \n" + e.getMessage());
        }
    }

    @Override
    public void excluir(Object o) throws SQLException {
        Produto produto = (Produto) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "DELETE FROM public.produto\n" +
"	WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores                     
            stmt.setLong(1, produto.getId());
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar remover a produto. \n" + e.getMessage());
        }
    }
    
    @Override
    public void excluir(int id) throws SQLException {
        
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "DELETE FROM public.produto\n" +
"	WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores                     
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar remover a produto. \n" + e.getMessage());
        }
    }

    @Override
    public List listarTodos() throws SQLException{
        List lista = new ArrayList();
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();
            String sql = "SELECT id, nome, modelo\n" +
"	FROM public.produto ORDER BY id ASC;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto c = new Produto();
                c.setNome(rs.getString("nome"));  

                c.setModelo(rs.getString("modelo"));
                c.setId(rs.getInt("id"));
                
                lista.add(c);
            }

            rs.close();
            stmt.close();
            
            return lista;
        } catch (SQLException e) {
            throw new SQLException("Eroo ao recuperar a lista de produtos. \n" + e.getMessage());
        }
    }

    @Override
    public Object listarPorId(int id) throws SQLException {
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();
            String sql = "SELECT id, nome, modelo\n" +
"	FROM public.produto WHERE id=?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Produto c = new Produto();
            c.setNome(rs.getString("nome"));
            c.setModelo(rs.getString("modelo"));
            c.setId(rs.getInt("id"));
            

            rs.close();
            stmt.close();
            
            return c;
        } catch (SQLException e) {
            throw new SQLException("Erro ao recuperar a produto. \n" + e.getMessage());
        }
    }
    
}
