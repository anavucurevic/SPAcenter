/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Maser;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ana
 */
public class TableModelMaseri extends AbstractTableModel implements Runnable {

    private ArrayList<Maser> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Specijalnost"};
    private String parametar = "";

    public TableModelMaseri() {
        try {
            lista = ClientController.getInstance().getAllMaser();
        } catch (Exception ex) {
            Logger.getLogger(TableModelMaseri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Maser m = lista.get(row);

        switch (column) {
            case 0:
                return m.getMaserID();
            case 1:
                return m.getImeMasera();
            case 2:
                return m.getPrezimeMasera();
            case 3:
                return m.getSpecijalnost();
            
            default:
                return null;
        }
    }

    public Maser getSelectedMaser(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(5000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelMaseri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllMaser();
            if (!parametar.equals("")) {
                ArrayList<Maser> novaLista = new ArrayList<>();
                for (Maser m : lista) {
                    if (m.getImeMasera().toLowerCase().contains(parametar.toLowerCase())
                            || m.getPrezimeMasera().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(m);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
