/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.estoque.controle;



import br.rj.macae.femass.estoque.dao.SetorDAO;
import br.rj.macae.femass.estoque.modelo.Setor;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author anamm
 */
public class SetorControle{
    public void gravar(Setor c)throws SQLException{
        SetorDAO dao = new SetorDAO();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(Setor c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta setor?")==JOptionPane.YES_OPTION){
            SetorDAO dao = new SetorDAO();    
            dao.excluir(c);
        }
        
    }
    public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta setor?")==JOptionPane.YES_OPTION){
            SetorDAO dao = new SetorDAO();    
            dao.excluir(id);
        }
    }
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        TableColumnModel modeloDaColuna = tabela.getColumnModel();
        modeloDaColuna.getColumn(0).setMaxWidth(25);

        //limpa as linhas da tabela.
        model.setNumRows(0);
        SetorDAO dao = new SetorDAO();
        List setors = dao.listarTodos();

        //Adiciona as linhas
        for (Object o : setors){
            Setor c = (Setor) o;
            
            model.addRow(new Object[]{c.getId(),c.getNome()});
            
        }   
    }

    public Setor getSetorPorId(int id) throws SQLException {
        SetorDAO dao = new SetorDAO();
        Setor c = (Setor)dao.listarPorId(id);
        return c;       
    }
}
