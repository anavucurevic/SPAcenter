/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import FormKlijent.FormNoviKlijent;
import FormKlijent.FormPretragaKlijenta;
import FormMasaza.FormNovaMasaza;
import FormMasaza.FormPretragaMasaze;
import FormMaser.FormNoviMaser;
import FormMaser.FormPretragaMaser;
import FormRezervacija.FormPretragaRezervacije;
import controller.ClientController;
import domain.Administrator;
import domain.Klijent;
import domain.Masaza;
import domain.Maser;
import domain.Rezervacija;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import session.Session;

/**
 *
 * @author Ana
 */
public class MainForm extends javax.swing.JFrame {

    Administrator a;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setLocationRelativeTo(null);
        this.a = Session.getInstance().getUlogovani();
        lblUlogovani.setText("Trenutno ulogovani administrator: " + a);
        popuniKlijente();
        popuniMasere();
        popuniMasaze();
        txtDatumVremeKraja.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        lblUlogovani = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbKlijent = new javax.swing.JComboBox();
        cmbMaser = new javax.swing.JComboBox();
        cmbMasaza = new javax.swing.JComboBox();
        cmbProstorija = new javax.swing.JComboBox();
        txtDatumVremePocetka = new javax.swing.JFormattedTextField();
        txtDatumVremeKraja = new javax.swing.JFormattedTextField();
        btnSacuvaj = new javax.swing.JButton();
        btnIzracunaj = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        miNoviKlijent = new javax.swing.JMenuItem();
        miPretragaKlijenta = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        miNovaMasaza = new javax.swing.JMenuItem();
        miPretragaMasaze = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        miNoviMaser = new javax.swing.JMenuItem();
        miPretragaMasera = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        miPretragaRez = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        miNovaMasaza1 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        jMenuItem2.setText("jMenuItem2");

        jMenu4.setText("File");
        jMenuBar3.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar3.add(jMenu5);

        jMenu10.setText("jMenu10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUlogovani.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        lblUlogovani.setText("Ulogovani");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos rezervacije"));

        jLabel1.setText("Klijent:");

        jLabel2.setText("Maser:");

        jLabel3.setText("Masaza:");

        jLabel4.setText("Prostorija:");

        jLabel5.setText("Datum i vreme pocetka:");

        jLabel6.setText("Datum i vreme kraja:");

        cmbKlijent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbMaser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbMasaza.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMasaza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMasazaItemStateChanged(evt);
            }
        });

        cmbProstorija.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A1", "A2", "A3", "B1", "B2", "B3" }));

        txtDatumVremePocetka.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"))));
        txtDatumVremePocetka.setText("10.10.2022 10:00");
        txtDatumVremePocetka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDatumVremePocetkaKeyReleased(evt);
            }
        });

        txtDatumVremeKraja.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"))));

        btnSacuvaj.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSacuvaj.setText("Sacuvaj rezervaciju");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnIzracunaj.setText("Izracunaj kraj termina");
        btnIzracunaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzracunajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(123, 123, 123)
                        .addComponent(cmbKlijent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbMaser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbMasaza, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbProstorija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDatumVremePocetka)
                            .addComponent(txtDatumVremeKraja)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnIzracunaj, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMaser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMasaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProstorija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDatumVremePocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIzracunaj)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatumVremeKraja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSacuvaj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu6.setText("Klijent");

        miNoviKlijent.setText("Novi klijent");
        miNoviKlijent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNoviKlijentActionPerformed(evt);
            }
        });
        jMenu6.add(miNoviKlijent);

        miPretragaKlijenta.setText("Pretraga klijenata");
        miPretragaKlijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaKlijentaActionPerformed(evt);
            }
        });
        jMenu6.add(miPretragaKlijenta);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Masaza");

        miNovaMasaza.setText("Nova masaza");
        miNovaMasaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNovaMasazaActionPerformed(evt);
            }
        });
        jMenu7.add(miNovaMasaza);

        miPretragaMasaze.setText("Pretraga masaze");
        miPretragaMasaze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaMasazeActionPerformed(evt);
            }
        });
        jMenu7.add(miPretragaMasaze);

        jMenuBar1.add(jMenu7);

        jMenu11.setText("Maser");

        miNoviMaser.setText("Novi maser");
        miNoviMaser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNoviMaserActionPerformed(evt);
            }
        });
        jMenu11.add(miNoviMaser);

        miPretragaMasera.setText("Pretraga masera");
        miPretragaMasera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaMaseraActionPerformed(evt);
            }
        });
        jMenu11.add(miPretragaMasera);

        jMenuBar1.add(jMenu11);

        jMenu9.setText("Rezervacija");

        miPretragaRez.setText("Pretraga rezervacije");
        miPretragaRez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaRezActionPerformed(evt);
            }
        });
        jMenu9.add(miPretragaRez);

        jMenuBar1.add(jMenu9);

        jMenu8.setText("Odjava");

        miNovaMasaza1.setText("Izloguj se");
        miNovaMasaza1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNovaMasaza1ActionPerformed(evt);
            }
        });
        jMenu8.add(miNovaMasaza1);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUlogovani)
                .addContainerGap(725, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUlogovani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miNoviKlijentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNoviKlijentActionPerformed
        new FormNoviKlijent(this, true).setVisible(true);
    }//GEN-LAST:event_miNoviKlijentActionPerformed

    private void miPretragaKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaKlijentaActionPerformed
        new FormPretragaKlijenta(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaKlijentaActionPerformed

    private void miNovaMasazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNovaMasazaActionPerformed
        new FormNovaMasaza(this, true).setVisible(true);
    }//GEN-LAST:event_miNovaMasazaActionPerformed

    private void miPretragaMasazeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaMasazeActionPerformed
        new FormPretragaMasaze(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaMasazeActionPerformed

    private void miNovaMasaza1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNovaMasaza1ActionPerformed

        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                + "se odjavite sa sistema?", "Konfirmacija", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_miNovaMasaza1ActionPerformed

    private void miPretragaRezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaRezActionPerformed
        new FormPretragaRezervacije(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaRezActionPerformed

    private void btnIzracunajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzracunajActionPerformed

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

            Date datumPocetka = sdf.parse(txtDatumVremePocetka.getText());

            Calendar calPocetak = Calendar.getInstance();
            Calendar calKraj = Calendar.getInstance();

            calPocetak.setTime(datumPocetka);
            calKraj.setTime(datumPocetka);

            Masaza m = (Masaza) cmbMasaza.getSelectedItem();

            calKraj.add(Calendar.MINUTE, m.getTrajanjeMinuti());

            Date datumKraja = calKraj.getTime();

            txtDatumVremeKraja.setText(String.valueOf(sdf.format(datumKraja)));

        } catch (ParseException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnIzracunajActionPerformed

    private void cmbMasazaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMasazaItemStateChanged

        if (cmbMasaza.getSelectedItem() != null) {
            txtDatumVremeKraja.setText("");
        }

    }//GEN-LAST:event_cmbMasazaItemStateChanged

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        if(txtDatumVremeKraja.getText().isEmpty() || txtDatumVremePocetka.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Datum i vreme pocetka i kraja moraju biti popunjeni!");
            return;
        }
        
        try {
            Klijent klijent = (Klijent) cmbKlijent.getSelectedItem();
            Maser maser = (Maser) cmbMaser.getSelectedItem();
            Masaza masaza = (Masaza) cmbMasaza.getSelectedItem();
            String prostorija = (String) cmbProstorija.getSelectedItem();
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date datumPocetka = sdf.parse(txtDatumVremePocetka.getText());
            Date datumKraja = sdf.parse(txtDatumVremeKraja.getText());
            
            Rezervacija r = new Rezervacija(null, datumPocetka, datumKraja, 
                    prostorija, klijent, maser, masaza, a);
            
            ClientController.getInstance().addRezervacija(r);
            JOptionPane.showMessageDialog(this, "Uspesno sacuvana rezervacija.");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void txtDatumVremePocetkaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDatumVremePocetkaKeyReleased
        
        txtDatumVremeKraja.setText("");
        
    }//GEN-LAST:event_txtDatumVremePocetkaKeyReleased

    private void miNoviMaserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNoviMaserActionPerformed
        new FormNoviMaser(this, true).setVisible(true);
    }//GEN-LAST:event_miNoviMaserActionPerformed

    private void miPretragaMaseraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaMaseraActionPerformed
        new FormPretragaMaser(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaMaseraActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzracunaj;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbKlijent;
    private javax.swing.JComboBox cmbMasaza;
    private javax.swing.JComboBox cmbMaser;
    private javax.swing.JComboBox cmbProstorija;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUlogovani;
    private javax.swing.JMenuItem miNovaMasaza;
    private javax.swing.JMenuItem miNovaMasaza1;
    private javax.swing.JMenuItem miNoviKlijent;
    private javax.swing.JMenuItem miNoviMaser;
    private javax.swing.JMenuItem miPretragaKlijenta;
    private javax.swing.JMenuItem miPretragaMasaze;
    private javax.swing.JMenuItem miPretragaMasera;
    private javax.swing.JMenuItem miPretragaRez;
    private javax.swing.JFormattedTextField txtDatumVremeKraja;
    private javax.swing.JFormattedTextField txtDatumVremePocetka;
    // End of variables declaration//GEN-END:variables

    public void popuniKlijente() {
        try {
            ArrayList<Klijent> klijenti = ClientController.getInstance().getAllKlijent();

            cmbKlijent.removeAllItems();

            for (Klijent klijent : klijenti) {
                cmbKlijent.addItem(klijent);
            }

        } catch (Exception ex) {
            Logger.getLogger(FormNovaMasaza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void popuniMasere() {
        try {
            ArrayList<Maser> maseri = ClientController.getInstance().getAllMaser();

            cmbMaser.removeAllItems();

            for (Maser maser : maseri) {
                cmbMaser.addItem(maser);
            }

        } catch (Exception ex) {
            Logger.getLogger(FormNovaMasaza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void popuniMasaze() {
        try {
            ArrayList<Masaza> masaze = ClientController.getInstance().getAllMasaza();

            cmbMasaza.removeAllItems();

            for (Masaza masaza : masaze) {
                cmbMasaza.addItem(masaza);
            }

        } catch (Exception ex) {
            Logger.getLogger(FormNovaMasaza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
