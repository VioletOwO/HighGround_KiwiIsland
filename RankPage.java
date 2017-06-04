/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import nz.ac.aut.ense701.gameModel.Record;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrator
 */
public class RankPage extends javax.swing.JFrame {

    /**
     * Creates new form RankPage
     */
    public RankPage() {
        initComponents();
        this.setTableContentCenter();
        this.addTableItems();
    }
    
    private void setTableContentCenter(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        this.jTable1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        this.jTable1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        this.jTable1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
    }
    
    public void addTableItems(){
        ArrayList<Record> records = Record.getTopTenPlayer();
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        int num = 0;
        for(Record r: records){
            model.insertRow(num, new Object[]{num + 1, r.getName(), r.getMark()});
            num++;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        rankPageTitleLabel = new javax.swing.JLabel();
        backButtonRankPage = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        rankPageTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        rankPageTitleLabel.setForeground(new java.awt.Color(153, 74, 2));
        rankPageTitleLabel.setText("RANK LIST");
        getContentPane().add(rankPageTitleLabel);
        rankPageTitleLabel.setBounds(113, 6, 132, 29);

        backButtonRankPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/gui/image/backButton.png"))); // NOI18N
        backButtonRankPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonRankPageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonRankPageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonRankPageMouseExited(evt);
            }
        });
        getContentPane().add(backButtonRankPage);
        backButtonRankPage.setBounds(120, 510, 120, 46);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Rank", "Player Name", "Mark"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(40, 120, 290, 200);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/gui/image/tutorialBackground.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 360, 570);

        pack();
    }// </editor-fold>                        

    private void backButtonRankPageMouseEntered(java.awt.event.MouseEvent evt) {                                                
        ImageIcon backIcon = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/gui/image/backButtonHover.png"));
        backButtonRankPage.setIcon(backIcon);
    }                                               

    private void backButtonRankPageMouseExited(java.awt.event.MouseEvent evt) {                                               
        ImageIcon backIcon = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/gui/image/backButton.png"));
        backButtonRankPage.setIcon(backIcon);
    }                                              

    private void backButtonRankPageMouseClicked(java.awt.event.MouseEvent evt) {                                                
        this.dispose();
    }                                               

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
            java.util.logging.Logger.getLogger(RankPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RankPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RankPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RankPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RankPage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JLabel backButtonRankPage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel rankPageTitleLabel;
    // End of variables declaration                   
}