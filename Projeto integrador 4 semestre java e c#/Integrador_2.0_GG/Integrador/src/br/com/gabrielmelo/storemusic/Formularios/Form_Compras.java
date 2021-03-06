/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gabrielmelo.storemusic.Formularios;

import br.com.gabrielmelo.storemusic.BO.ComprasBO;
import br.com.gabrielmelo.storemusic.BO.FornecedorBO;
import br.com.gabrielmelo.storemusic.BO.ItensCompraBO;
import br.com.gabrielmelo.storemusic.BO.ProdutosBO;
import br.com.gabrielmelo.storemusic.TO.CompraTO;
import br.com.gabrielmelo.storemusic.TO.FornecedorTO;
import br.com.gabrielmelo.storemusic.TO.ItensComprasTO;
import br.com.gabrielmelo.storemusic.TO.LoginTO;
import br.com.gabrielmelo.storemusic.TO.ProdutosTO;
import java.awt.event.KeyEvent;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davi
 */
public class Form_Compras extends javax.swing.JFrame {
      //private Form_Con_Produtos_compra veioframe;
      
   
    
    public void preencherCampo(int id){
        FornecedorTO c = new FornecedorTO();
        c.setCod_forn(id);
        
        ListIterator<FornecedorTO> lstiP = new FornecedorBO().getNomeId(c).listIterator();
        
          while(lstiP.hasNext())
        {
            c = lstiP.next();
            
            txtFornecedor.setText(c.getNome_fant());
            txtCNPJ.setText(c.getCnpj());
            
        } 
    }
    
  Form_Con_Produtos_compra janela = new Form_Con_Produtos_compra();
  
  public void retorna1(String nome){
        txtBarras.setText(String.valueOf(nome));
                txtBarras.requestFocus();

    }
  
  
    public void cadastrarItens(int cod_compra){

     for(int i=0; i<tblCompra.getRowCount(); i++){    
    int qtd = Integer.parseInt(tblCompra.getValueAt(i, 2).toString()); 
    int cod_prod = Integer.parseInt(tblCompra.getValueAt(i, 0).toString()); 
        
         ItensComprasTO iv = new ItensComprasTO();
         ItensCompraBO ivBO = new ItensCompraBO();
        iv.setQuantidade(qtd);
        iv.setCod_prod(cod_prod);
        iv.setCod_comp(cod_compra);
        iv.setSituacao(0);
        ivBO.salvar(iv);
     }
    }
   public int cadastrarCompras(){
      
    
        CompraTO c = new CompraTO();
        ComprasBO cBO = new ComprasBO();
        c.setValor_tot(Float.parseFloat(lblSubtotal.getText()));
        c.setCod_func(1);
        //v.setCod_cli(Integer.parseInt(jLabel4.getText()));
        c.setCod_forn(Integer.parseInt(jLabel1.getText()));
        System.out.print(jLabel4.getText());
        cBO.salvar(c);
       return(c.getCod_comp());

 } 
     
public void CalcSubtotal(){
    try {
        
    
   Double rs = 0.0;  
     for ( int i = 0; i < tblCompra.getRowCount(); i++){  
         rs += Double.parseDouble( tblCompra.getValueAt(i, 4).toString());  
     } 
    
  lblSubtotal.setText(String.valueOf(rs));  
  //valorTotal = 0;  
  } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "ERRO "+e);

      
  }
} 
public void AdicionarProduto(ProdutosTO x){
        DefaultTableModel tabelaP = (DefaultTableModel)tblCompra.getModel();
        ProdutosTO gmcp = new ProdutosTO();
        ProdutosBO gmcpBo = new ProdutosBO();
        ListIterator<ProdutosTO> lstiP = gmcpBo.getNomeId(x).listIterator();
            while(lstiP.hasNext()){
                gmcp = lstiP.next();
                float t = (gmcp.getValor_custo());
                float x1 = (t * Float.parseFloat(txtqtd.getText()));
                tabelaP.addRow(new Object[]{gmcp.getCod_prod(),gmcp.getNome(),txtqtd.getText(),gmcp.getValor_custo(),x1});
            }
    }
    public Form_Compras() {
        initComponents();
        preencherTabela();
    

    }
       public Form_Compras(int x) {
        initComponents();
           preencherCampo(x);
           jLabel1.setVisible(false);
           jLabel1.setText(String.valueOf(x));
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompra = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFornecedor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtBarras = new javax.swing.JTextField();
        txtqtd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(238, 220, 192));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Compras"));

        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Quantidade", "Preço_custo", "SubTotal"
            }
        ));
        tblCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCompra);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Fornecedor"));

        jLabel1.setText("jLabel1");

        txtFornecedor.setEditable(false);
        txtFornecedor.setEnabled(false);

        jLabel2.setText("Nome");

        jLabel4.setText("CNPJ");

        txtCNPJ.setEditable(false);
        txtCNPJ.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFornecedor)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Produto"));

        jLabel3.setText("Codigo de barras");

        txtBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBarrasKeyPressed(evt);
            }
        });

        txtqtd.setText("1");
        txtqtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtqtdKeyPressed(evt);
            }
        });

        jLabel5.setText("Quantidade");

        jButton3.setText("Escolher Produto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBarras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jButton3)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Subtotal: ");

        lblSubtotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton2.setText("Finalizar Compras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jLabel6))))
                .addGap(8, 8, 8))
        );

        jMenu1.setText("Sair");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void preencherTabela(){
        DefaultTableModel tabelaP = (DefaultTableModel)tblCompra.getModel();
        FornecedorTO gmcp = new FornecedorTO();
        FornecedorBO gmcpBo = new FornecedorBO();
        ListIterator<FornecedorTO> lstiP = gmcpBo.getFornecedor().listIterator();
            while(lstiP.hasNext()){
                gmcp = lstiP.next();
                tabelaP.addRow(new Object[]{gmcp.getCod_forn(),gmcp.getNome_fant(),gmcp.getCnpj(),gmcp.getInscricao_est(),gmcp.getLogradouro(),
                    gmcp.getNumero(),gmcp.getCep(),gmcp.getComplemento(),gmcp.getTelefone(),gmcp.getCelular()});
            }
    }
    private void txtBarrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarrasKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           txtqtd.requestFocus();
       }
    }//GEN-LAST:event_txtBarrasKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       double x = Double.parseDouble(lblSubtotal.getText());
       int zz = cadastrarCompras();
       cadastrarItens(zz);
      Form_finalizar_compra finaliza = new Form_finalizar_compra(zz,Float.parseFloat(lblSubtotal.getText()));
      finaliza.setVisible(true);
        this.dispose();


       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCompraMouseClicked
        int x = JOptionPane.showConfirmDialog(null, "Deseja Remover esse Produto?");
       if(x == 0){
           int linha = tblCompra.getSelectedRow();
          ((DefaultTableModel) tblCompra.getModel()).removeRow(linha);
       
       
       }
    }//GEN-LAST:event_tblCompraMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         if(janela == null){
                janela = new Form_Con_Produtos_compra();
                janela.setLocationRelativeTo(null);
                janela.setVisible(true);
                janela.setResizable(false);
            }else{
                 janela.setVisible(true);
                janela.setResizable(false);
            }
               janela.envia(this, null); 
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtqtdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtqtdKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             try {
       ProdutosTO p = new ProdutosTO();
        p.setCod_barras(txtBarras.getText());
        AdicionarProduto(p);
        CalcSubtotal();
        txtBarras.setText("");
        txtBarras.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produto Invalido");
        }
       }
    }//GEN-LAST:event_txtqtdKeyPressed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Compras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JTable tblCompra;
    private javax.swing.JTextField txtBarras;
    private javax.swing.JTextField txtCNPJ;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtqtd;
    // End of variables declaration//GEN-END:variables

  
}
