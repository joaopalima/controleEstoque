/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.estoque.controle;



import br.rj.macae.femass.estoque.dao.ProdutoDAO;
import br.rj.macae.femass.estoque.modelo.Produto;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author anamm
 */
public class ProdutoControle{
    public void gravar(Produto c)throws SQLException{
        ProdutoDAO dao = new ProdutoDAO();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(Produto c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta material?")==JOptionPane.YES_OPTION){
            ProdutoDAO dao = new ProdutoDAO();    
            dao.excluir(c);
        }
    }
    
    
    public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta material?")==JOptionPane.YES_OPTION){
            ProdutoDAO dao = new ProdutoDAO();    
            dao.excluir(id);
        }
    }
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        TableColumnModel modeloDaColuna = tabela.getColumnModel();
        modeloDaColuna.getColumn(0).setMaxWidth(25);

        //limpa as linhas da tabela.
        model.setNumRows(0);
        
        ProdutoDAO dao = new ProdutoDAO();
        List materials = dao.listarTodos();

        //Adiciona as linhas
        for (Object o : materials){
            Produto c = (Produto) o;
            
            model.addRow(new Object[]{c.getId(),c.getNome(),c.getModelo()});
            
        }  
    }

    public Produto getMaterialPorId(int id) throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        Produto c = (Produto)dao.listarPorId(id);
        return c;       
    }
}
