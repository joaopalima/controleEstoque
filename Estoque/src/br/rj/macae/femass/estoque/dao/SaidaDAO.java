/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.estoque.dao;



import br.rj.macae.femass.estoque.modelo.Empregado;
import br.rj.macae.femass.estoque.modelo.Produto;
import br.rj.macae.femass.estoque.modelo.Saida;
import br.rj.macae.femass.estoque.modelo.Saida_Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public class SaidaDAO implements IDAO{

    @Override
    public void adicionar(Object o) throws SQLException {
        Saida saida = (Saida) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "INSERT INTO public.saida(\n" +
"	data, comentario, empregado, produto)\n" +
"	VALUES (?,?,?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            stmt.setString(1, saida.getData());
            stmt.setString(2, saida.getComentario());
            stmt.setInt(3, saida.getEmpregado().getId());
           // stmt.setInt(4, saida.getProduto().getId());
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar cadastrar a saida. \n" + e.getMessage());
        }
    }

    @Override
    public void alterar(Object o) throws SQLException {
        Saida saida = (Saida) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "UPDATE public.saida\n" +
"	SET data=?, comentario=?, empregado=?, produto=? \n" +
"	WHERE id = ?";
        
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            stmt.setString(1, saida.getData());
            stmt.setString(2, saida.getComentario());
            stmt.setInt(3, saida.getEmpregado().getId());
            //stmt.setInt(4, saida.getProduto().getId());
            stmt.setInt(5, saida.getId());
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar alterar a saida. \n" + e.getMessage());
        }
    }

    @Override
    public void excluir(Object o) throws SQLException {
        Saida saida = (Saida) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "DELETE FROM public.saida\n" +
"	WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores                     
            stmt.setLong(1, saida.getId());
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar remover a saida. \n" + e.getMessage());
        }
    }
    
    @Override
    public void excluir(int id) throws SQLException {
        
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "DELETE FROM public.saida\n" +
"	WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores                     
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar remover a saida. \n" + e.getMessage());
        }
    }

    @Override
    public List listarTodos() throws SQLException{
        List lista = new ArrayList();
        Connection conn = null;
        EmpregadoDAO cdao = new EmpregadoDAO();
        ProdutoDAO edao = new ProdutoDAO();
        try {
            conn = FabricaConexao.getConexao();
            String sql = "SELECT id, data, comentario, empregado, produto\n" +
"	FROM public.saida ORDER BY id ASC;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Saida c = new Saida();
                c.setData(rs.getString("data"));  
                c.setComentario(rs.getString("comentario"));
                c.setEmpregado((Empregado)cdao.listarPorId(rs.getInt("empregado")));
                c.setProduto((Produto)edao.listarPorId(rs.getInt("produto")));
                
                c.setId(rs.getInt("id"));
                recuperarMateriais(c);
                lista.add(c);
            }

            rs.close();
            stmt.close();
            
            return lista;
        } catch (SQLException e) {
            throw new SQLException("Erro ao recuperar a lista de saidas. \n" + e.getMessage());
        }
    }

    @Override
    public Object listarPorId(int id) throws SQLException {
        Connection conn = null;
        EmpregadoDAO cdao = new EmpregadoDAO();
        ProdutoDAO edao = new ProdutoDAO();
        try {
            conn = FabricaConexao.getConexao();
            String sql = "SELECT id, data, comentario, empregado, produto\n" +
"	FROM public.saida WHERE id=?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Saida c = new Saida();
            c.setData(rs.getString("data"));  
                c.setComentario(rs.getString("comentario"));
                c.setEmpregado((Empregado)cdao.listarPorId(rs.getInt("empregado")));
                c.setProduto((Produto)edao.listarPorId(rs.getInt("produto")));
            c.setId(rs.getInt("id"));
            

            rs.close();
            stmt.close();
            
            return c;
        } catch (SQLException e) {
            throw new SQLException("Erro ao recuperar a saida. \n" + e.getMessage());
        }
    }
    
    private void recuperarMateriais(Saida r) throws SQLException{
        Connection conn = null;
        ProdutoDAO dao = new ProdutoDAO();
        try {
            conn = FabricaConexao.getConexao();
            String sql = "SELECT os, Produto, quantidade, unidade\n" +
"	FROM public.saida_Produto WHERE os=?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, r.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){            
                Saida_Produto Produto = new Saida_Produto();
                Produto.setQuantidade(rs.getFloat("quantidade"));
                Produto.setUnidade(rs.getString("unidade"));
                Produto.setProduto((Produto)dao.listarPorId(rs.getInt("Produto")));
                r.setProduto(Produto);
            }

            rs.close();
            stmt.close();
            
            
        } catch (SQLException e) {
            throw new SQLException("Eroo ao recuperar Produto da receita. \n" + e.getMessage());
        }
    }
}
