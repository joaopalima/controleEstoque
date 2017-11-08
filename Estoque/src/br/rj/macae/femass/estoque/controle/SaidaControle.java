/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.estoque.controle;




import br.rj.macae.femass.estoque.dao.EmpregadoDAO;
import br.rj.macae.femass.estoque.dao.ProdutoDAO;
import br.rj.macae.femass.estoque.dao.SaidaDAO;
import br.rj.macae.femass.estoque.dao.SetorDAO;
import br.rj.macae.femass.estoque.modelo.Saida;
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
public class SaidaControle{
    public void gravar(Saida c)throws SQLException{
        SaidaDAO dao = new SaidaDAO();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(Saida c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta material?")==JOptionPane.YES_OPTION){
            SaidaDAO dao = new SaidaDAO();    
            dao.excluir(c);
        }
        
    }
    public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta material?")==JOptionPane.YES_OPTION){
            SaidaDAO dao = new SaidaDAO();    
            dao.excluir(id);
        }
    }
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        TableColumnModel modeloDaColuna = tabela.getColumnModel();
       

        //limpa as linhas da tabela.
        model.setNumRows(0);
        
        SaidaDAO dao = new SaidaDAO();
        List materials = dao.listarTodos();

        //Adiciona as linhas
        for (Object o : materials){
            Saida c = (Saida) o;
            
            model.addRow(new Object[]{c.getId(),c.getData(), c.getComentario(),c.getProduto(), c.getEmpregado()});
            
        }
        
        
    }

    public Saida getSaidaPorId(int id) throws SQLException {
        SaidaDAO dao = new SaidaDAO();
        Saida c = (Saida)dao.listarPorId(id);
        return c;       
    }
    
    public List listarEmpregados() throws SQLException {
        EmpregadoDAO dao = new EmpregadoDAO();
        return dao.listarTodos();
    }

    public List listarProdutos() throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.listarTodos();
    }
    
    public List listarSetor() throws SQLException {
        SetorDAO dao = new SetorDAO();
        return dao.listarTodos();
    }
    
}
