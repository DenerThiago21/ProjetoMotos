/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author dener
 */
public class FPrincipal extends javax.swing.JFrame
{

    /**
     * Creates new form FPrincipal
     */
    public FPrincipal()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jMenuItem4 = new javax.swing.JMenuItem();
        mbPrincipal = new javax.swing.JMenuBar();
        mCadastro = new javax.swing.JMenu();
        miCadCliente = new javax.swing.JMenuItem();
        miCadMoto = new javax.swing.JMenuItem();
        mPesquisa = new javax.swing.JMenu();
        miPesqCliente = new javax.swing.JMenuItem();
        miPesqMoto = new javax.swing.JMenuItem();
        mRelatorio = new javax.swing.JMenu();
        mVenda = new javax.swing.JMenu();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mCadastro.setText("Cadastro");

        miCadCliente.setText("Clientes");
        miCadCliente.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                miCadClienteActionPerformed(evt);
            }
        });
        mCadastro.add(miCadCliente);

        miCadMoto.setText("Motos");
        miCadMoto.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                miCadMotoActionPerformed(evt);
            }
        });
        mCadastro.add(miCadMoto);

        mbPrincipal.add(mCadastro);

        mPesquisa.setText("Pesquisa");

        miPesqCliente.setText("Clientes");
        mPesquisa.add(miPesqCliente);

        miPesqMoto.setText("Motos");
        mPesquisa.add(miPesqMoto);

        mbPrincipal.add(mPesquisa);

        mRelatorio.setText("Relátorio");
        mbPrincipal.add(mRelatorio);

        mVenda.setText("Vendas");
        mbPrincipal.add(mVenda);

        setJMenuBar(mbPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCadMotoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miCadMotoActionPerformed
    {//GEN-HEADEREND:event_miCadMotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miCadMotoActionPerformed

    private void miCadClienteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miCadClienteActionPerformed
    {//GEN-HEADEREND:event_miCadClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miCadClienteActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem4;
    public javax.swing.JMenu mCadastro;
    public javax.swing.JMenu mPesquisa;
    public javax.swing.JMenu mRelatorio;
    public javax.swing.JMenu mVenda;
    private javax.swing.JMenuBar mbPrincipal;
    public javax.swing.JMenuItem miCadCliente;
    public javax.swing.JMenuItem miCadMoto;
    public javax.swing.JMenuItem miPesqCliente;
    public javax.swing.JMenuItem miPesqMoto;
    // End of variables declaration//GEN-END:variables
}