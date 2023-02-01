package Vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

public class VistaPrincipal extends javax.swing.JFrame {

    public VistaPrincipal() {
        initComponents();
    }
    public JButton getBtnCamionero() {
        return btnCamionero;
    }

    public void setBtnCamionero(JButton btnCamionero) {
        this.btnCamionero = btnCamionero;
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JButton getBtncamion() {
        return btncamion;
    }

    public void setBtncamion(JButton btncamion) {
        this.btncamion = btncamion;
    }

    public JButton getBtnprovincia() {
        return btnprovincia;
    }

    public void setBtnprovincia(JButton btnprovincia) {
        this.btnprovincia = btnprovincia;
    }

    public JButton getBtnCliente() {
        return btnCliente;
    }

    public void setBtnCliente(JButton btnCliente) {
        this.btnCliente = btnCliente;
    }

    public JButton getBtndestinatario() {
        return btndestinatario;
    }

    public void setBtndestinatario(JButton btndestinatario) {
        this.btndestinatario = btndestinatario;
    }

    public JButton getBtnconduce() {
        return btnconduce;
    }

    public void setBtnconduce(JButton btnconduce) {
        this.btnconduce = btnconduce;
    }

    public JButton getBtnpaquetes() {
        return btnpaquetes;
    }

    public void setBtnpaquetes(JButton btnpaquetes) {
        this.btnpaquetes = btnpaquetes;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        btnpaquetes = new javax.swing.JButton();
        btnconduce = new javax.swing.JButton();
        btndestinatario = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnprovincia = new javax.swing.JButton();
        btncamion = new javax.swing.JButton();
        btnCamionero = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnpaquetes.setBackground(new java.awt.Color(102, 102, 102));
        btnpaquetes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/869134.1.png"))); // NOI18N
        btnpaquetes.setText("Paquete");
        btnpaquetes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnpaquetes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnpaquetes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnpaquetes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                btnpaquetesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        escritorio.add(btnpaquetes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 100, 100));

        btnconduce.setBackground(new java.awt.Color(102, 102, 102));
        btnconduce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1582039.1.png"))); // NOI18N
        btnconduce.setText("Viaje");
        btnconduce.setToolTipText("Horarios de conduccion");
        btnconduce.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnconduce.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnconduce.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnconduce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconduceActionPerformed(evt);
            }
        });
        escritorio.add(btnconduce, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 100, 100));

        btndestinatario.setBackground(new java.awt.Color(102, 102, 102));
        btndestinatario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1514134.1.png"))); // NOI18N
        btndestinatario.setText("Destinantario");
        btndestinatario.setToolTipText("Destinatarios");
        btndestinatario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btndestinatario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btndestinatario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        escritorio.add(btndestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 110, 100));

        btnCliente.setBackground(new java.awt.Color(102, 102, 102));
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/57117.1.png"))); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.setToolTipText("Clientes");
        btnCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        escritorio.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 100, 100));

        btnprovincia.setBackground(new java.awt.Color(102, 102, 102));
        btnprovincia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2970119.1.png"))); // NOI18N
        btnprovincia.setText("Provincia");
        btnprovincia.setToolTipText("Provincias");
        btnprovincia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnprovincia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnprovincia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        escritorio.add(btnprovincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 100, 100));

        btncamion.setBackground(new java.awt.Color(102, 102, 102));
        btncamion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/240_F_329598014_GY8XKn9Qfgt90oprNZr6tkmgeMocDEIK.1.jpg"))); // NOI18N
        btncamion.setText("Camion");
        btncamion.setToolTipText("Camiones");
        btncamion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btncamion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncamion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        escritorio.add(btncamion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 100, 100));

        btnCamionero.setBackground(new java.awt.Color(102, 102, 102));
        btnCamionero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/240_F_144857936_YnamdZNvaKofxs9vmvJlyEao4Ai2EuJd.1.jpg"))); // NOI18N
        btnCamionero.setText("Camionero");
        btnCamionero.setToolTipText("Camioneros");
        btnCamionero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCamionero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCamionero.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        escritorio.add(btnCamionero, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 110, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("INICIO");
        escritorio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpaquetesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btnpaquetesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpaquetesAncestorAdded

    private void btnconduceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconduceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnconduceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCamionero;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btncamion;
    private javax.swing.JButton btnconduce;
    private javax.swing.JButton btndestinatario;
    private javax.swing.JButton btnpaquetes;
    private javax.swing.JButton btnprovincia;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
