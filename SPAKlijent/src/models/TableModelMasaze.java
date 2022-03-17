/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Masaza;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ana
 */
public class TableModelMasaze extends AbstractTableModel implements Runnable {

    private ArrayList<Masaza> lista;
    private String[] kolone = {"ID", "Naziv masaze", "Cena", "Trajanje"};
    private String parametar = "";

    public TableModelMasaze() {
        try {
            lista = ClientController.getInstance().getAllMasaza();
        } catch (Exception ex) {
            Logger.getLogger(TableModelMasaze.class.getName()).log(Level.SEVERE, null, ex);
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
        Masaza m = lista.get(row);

        switch (column) {
            case 0:
                return m.getMasazaID();
            case 1:
                return m.getNazivMasaze();
            case 2:
                return m.getCena();
            case 3:
                return m.getTrajanjeMinuti();

            default:
                return null;
        }
    }

    public Masaza getSelectedMasaza(int row) {
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
            Logger.getLogger(TableModelMasaze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllMasaza();
            if (!parametar.equals("")) {
                ArrayList<Masaza> novaLista = new ArrayList<>();
                for (Masaza m : lista) {
                    if (m.getNazivMasaze().toLowerCase().contains(parametar.toLowerCase())) {
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
