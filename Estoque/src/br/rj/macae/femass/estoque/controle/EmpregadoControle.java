/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.estoque.controle;


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
public class EmpregadoControle{
    public void gravar(Empregado c)throws SQLException{
        EmpregadoDAO dao = new EmpregadoDAO();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(Empregado c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta empregado?")==JOptionPane.YES_OPTION){
            EmpregadoDAO dao = new EmpregadoDAO();    
            dao.excluir(c);
        }
        
    }
    public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta empregado?")==JOptionPane.YES_OPTION){
            EmpregadoDAO dao = new EmpregadoDAO();    
            dao.excluir(id);
        }
    }
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        TableColumnModel modeloDaColuna = tabela.getColumnModel();
        modeloDaColuna.getColumn(0).setMaxWidth(25);

        //limpa as linhas da tabela.
        model.setNumRows(0);
        EmpregadoDAO dao = new EmpregadoDAO();
        List empregados = dao.listarTodos();

        //Adiciona as linhas
        for (Object o : empregados){
            Empregado c = (Empregado) o;
            
            model.addRow(new Object[]{c.getId(),c.getNome()});
            
        }
        
        
    }

    public Empregado getEmpregadoPorId(int id) throws SQLException {
        EmpregadoDAO dao = new EmpregadoDAO();
        Empregado c = (Empregado)dao.listarPorId(id);
        return c;       
    }
}
