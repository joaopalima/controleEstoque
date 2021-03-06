/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.estoque.gui;


import br.rj.macae.femass.estoque.controle.SaidaControle;
import br.rj.macae.femass.estoque.modelo.Empregado;
import br.rj.macae.femass.estoque.modelo.Produto;
import br.rj.macae.femass.estoque.modelo.Saida;
import br.rj.macae.femass.estoque.modelo.Saida_Produto;
import br.rj.macae.femass.estoque.modelo.Setor;
import static java.lang.System.exit;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class GuiSaida extends javax.swing.JInternalFrame {

    /**
     * Creates new form guiClient
     */
    public GuiSaida() {
        initComponents();
        setResizable(false);

        setTitle("Manter saida");
        DefaultListModel model = new DefaultListModel();
        lstProdutos.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSaida = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        pNovo = new javax.swing.JPanel();
        txtData = new javax.swing.JTextField();
        lbData = new javax.swing.JLabel();
        btnGravar = new javax.swing.JButton();
        lbComentario = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        cboEmpregados = new javax.swing.JComboBox();
        lbData2 = new javax.swing.JLabel();
        cboSetor = new javax.swing.JComboBox();
        lbData3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstProdutos = new javax.swing.JList();
        lbComentario1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnRmv = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbData4 = new javax.swing.JLabel();
        cboProduto = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        lbData5 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JTextField();
        txtUn = new javax.swing.JTextField();
        lbData6 = new javax.swing.JLabel();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        tblSaida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Produto", "Empregado", "Comentario", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSaida.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tblSaida);
        if (tblSaida.getColumnModel().getColumnCount() > 0) {
            tblSaida.getColumnModel().getColumn(0).setResizable(false);
            tblSaida.getColumnModel().getColumn(4).setResizable(false);
        }

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        pNovo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saída de Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N

        lbData.setText("Data:");

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        lbComentario.setText("Comentario:");

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        jScrollPane2.setViewportView(txtComentario);

        cboEmpregados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmpregadosActionPerformed(evt);
            }
        });

        lbData2.setText("Empregado:");

        cboSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSetorActionPerformed(evt);
            }
        });

        lbData3.setText("Setor:");

        jScrollPane3.setViewportView(lstProdutos);

        lbComentario1.setText("Produtos:");

        btnAdd.setText("+");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRmv.setText("-");
        btnRmv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRmvActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lbData4.setText("Produto:");

        lbData5.setText("Qtd:");

        txtQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdActionPerformed(evt);
            }
        });

        lbData6.setText("Un:");

        javax.swing.GroupLayout pNovoLayout = new javax.swing.GroupLayout(pNovo);
        pNovo.setLayout(pNovoLayout);
        pNovoLayout.setHorizontalGroup(
            pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNovoLayout.createSequentialGroup()
                .addGroup(pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pNovoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pNovoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pNovoLayout.createSequentialGroup()
                                .addGroup(pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbData)
                                    .addComponent(lbData2)
                                    .addComponent(lbData4)
                                    .addComponent(lbComentario1)
                                    .addComponent(lbData3)
                                    .addComponent(lbComentario))
                                .addGap(31, 31, 31)
                                .addGroup(pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pNovoLayout.createSequentialGroup()
                                        .addComponent(cboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbData5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbData6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtUn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnRmv, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cboSetor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboEmpregados, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pNovoLayout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGravar)))))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        pNovoLayout.setVerticalGroup(
            pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNovoLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbData2)
                    .addComponent(cboEmpregados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbData3)
                    .addComponent(cboSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbData6)
                        .addComponent(txtUn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd)
                        .addComponent(btnRmv))
                    .addGroup(pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbData4)
                        .addComponent(lbData5)
                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbComentario1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbComentario))
                .addGap(18, 18, 18)
                .addGroup(pNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnGravar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(627, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovo)
                            .addComponent(btnAlterar)
                            .addComponent(btnExcluir)
                            .addComponent(btnAtualizar))
                        .addGap(18, 18, 18)
                        .addComponent(pNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limparCampos();
        habilitarCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (tblSaida.getSelectedRow() >= 0) {
            SaidaControle controle = new SaidaControle();
            Object valor = ((DefaultTableModel) tblSaida.getModel()).getValueAt(tblSaida.getSelectedRow(), 0);
            try {
            limparCampos();
            Saida c = controle.getSaidaPorId((Integer) valor);
            txtData.setText(c.getData());
            txtComentario.setText(c.getComentario());  
            cboEmpregados.setSelectedItem(c.getEmpregado());
            cboSetor.setSelectedItem(c.getProduto());

                habilitarCampos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela.");
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblSaida.getSelectedRow() >= 0) {
            SaidaControle controle = new SaidaControle();
            Object valor = ((DefaultTableModel) tblSaida.getModel()).getValueAt(tblSaida.getSelectedRow(), 0);
            try {
                Saida c = controle.getSaidaPorId((Integer) valor);
                controle.excluir(c);

                desabilitarCampos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela.");
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        SaidaControle controle = new SaidaControle();

        try {
            Saida c = new Saida();
            c.setData(txtData.getText());
            c.setComentario(txtComentario.getText());
            c.setEmpregado((Empregado) cboEmpregados.getSelectedItem());
            c.setProduto((Produto) cboProduto.getSelectedItem());
            c.setSetor((Setor) cboSetor.getSelectedItem());
            
            for(int i=0; i<lstProdutos.getModel().getSize();i++){            
            c.setProduto((Saida_Produto) lstProdutos.getModel().getElementAt(i));
            }
            
            if (tblSaida.getSelectedRow() >= 0) {
                c.setId((Integer) tblSaida.getValueAt(tblSaida.getSelectedRow(), 0));
            }
            

            controle.gravar(c);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception ex2) {
            JOptionPane.showMessageDialog(this, ex2.getMessage());
        }

        limparCampos();
        desabilitarCampos();
        atualizarLista();
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

        atualizarLista();
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        atualizarLista();
        desabilitarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        desabilitarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCampos();
        desabilitarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Saida_Produto ri = new Saida_Produto();
        ri.setProduto((Produto)cboProduto.getSelectedItem());        
        ri.setQuantidade(Integer.parseInt(txtQtd.getText()));
        ri.setUnidade(txtUn.getText());
        DefaultListModel model = (DefaultListModel) lstProdutos.getModel();
        model.addElement(ri);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRmvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRmvActionPerformed
        
        if(lstProdutos.isSelectionEmpty()){
        JOptionPane.showMessageDialog(this, "Selecione um produto da lista para excluir");
        return;
        }
        Saida_Produto ri = new Saida_Produto();
        
        DefaultListModel model = (DefaultListModel) lstProdutos.getModel();
        model.removeElementAt(lstProdutos.getSelectedIndex());
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRmvActionPerformed

    private void cboEmpregadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmpregadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEmpregadosActionPerformed

    private void txtQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdActionPerformed

    private void cboSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSetorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSetorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRmv;
    private javax.swing.JComboBox cboEmpregados;
    private javax.swing.JComboBox cboProduto;
    private javax.swing.JComboBox cboSetor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbComentario;
    private javax.swing.JLabel lbComentario1;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbData2;
    private javax.swing.JLabel lbData3;
    private javax.swing.JLabel lbData4;
    private javax.swing.JLabel lbData5;
    private javax.swing.JLabel lbData6;
    private javax.swing.JList lstProdutos;
    private javax.swing.JPanel pNovo;
    private javax.swing.JTable tblSaida;
    private javax.swing.JTextArea txtComentario;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtUn;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        txtData.setText("");
        txtQtd.setText("");
        txtUn.setText("");
        tblSaida.clearSelection();
        lstProdutos.clearSelection();
        try {
            atualizarComboEmpregado();
            cboEmpregados.setSelectedIndex(-1);
            atualizarComboProduto();
            cboSetor.setSelectedIndex(-1);
            atualizarComboSetor();
            cboProduto.setSelectedIndex(-1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void habilitarCampos() {
        pNovo.setVisible(true);
        txtData.requestFocus(true);
        btnGravar.setVisible(true);
        btnCancelar.setVisible(true);
        tblSaida.setEnabled(false);
    }

    private void desabilitarCampos() {
        pNovo.setVisible(false);
        btnGravar.setVisible(false);
        btnCancelar.setVisible(false);
        tblSaida.setEnabled(true);

    }

    private void atualizarLista() {
        SaidaControle controle = new SaidaControle();
        try {
            controle.atualizarLista(tblSaida);
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    private void atualizarComboEmpregado() throws SQLException {
        SaidaControle controle = new SaidaControle();
        List empregados = controle.listarEmpregados();
        cboEmpregados.removeAllItems();
        for(Object o:empregados){
            cboEmpregados.addItem(o);
        }
    }
    
        private void atualizarComboProduto() throws SQLException {
        SaidaControle controle = new SaidaControle();
        List equipamentos = controle.listarProdutos();
        cboProduto.removeAllItems();
        for(Object o:equipamentos){
            cboProduto.addItem(o);
        }
    }
        
            private void atualizarComboSetor() throws SQLException {
        SaidaControle controle = new SaidaControle();
        List setor = controle.listarSetor();
        cboSetor.removeAllItems();
        for(Object o:setor){
            cboSetor.addItem(o);
        }
    }
        
        private void atualizarProduto() {
        SaidaControle controle = new SaidaControle();
        List produtos;
        try {
            produtos = controle.listarProdutos();
            cboProduto.removeAllItems();
             for(Object o:produtos){
                cboProduto.addItem(o);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
            
    }

}
