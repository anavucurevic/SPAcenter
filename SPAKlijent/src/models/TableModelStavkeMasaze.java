/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Masaza;
import domain.RegijaTela;
import domain.StavkaMasaze;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ana
 */
public class TableModelStavkeMasaze extends AbstractTableModel {

    private ArrayList<StavkaMasaze> lista;
    private String[] kolone = {"Rb", "Regija tela", "Tehnika", "Trajanje (min)"};
    int rb = 0;

    public TableModelStavkeMasaze() {
        lista = new ArrayList<>();
    }

    public TableModelStavkeMasaze(Masaza m) {
        try {
            lista = ClientController.getInstance().getAllStavkaMasaze(m);
        } catch (Exception ex) {
            Logger.getLogger(TableModelStavkeMasaze.class.getName()).log(Level.SEVERE, null, ex);
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
        StavkaMasaze sm = lista.get(row);

        switch (column) {
            case 0:
                return sm.getRb();
            case 1:
                return sm.getRegija();
            case 2:
                return sm.getTehnika();
            case 3:
                return sm.getTrajanjeMinuti();

            default:
                return null;
        }
    }

    public void dodajStavku(StavkaMasaze sm) {

        if (rb != 0) {
            StavkaMasaze stavkaProvera = lista.get(rb - 1);
            if (stavkaProvera.getTehnika().equals(sm.getTehnika())
                    && stavkaProvera.getRegija().getNazivRegije().equals(sm.getRegija().getNazivRegije())) {
                stavkaProvera.setTrajanjeMinuti(stavkaProvera.getTrajanjeMinuti() + sm.getTrajanjeMinuti());
                fireTableDataChanged();
                return;
            }
        }

        rb = 0;
        for (StavkaMasaze stavkaMasaze : lista) {
            stavkaMasaze.setRb(++rb);
        }

        sm.setRb(++rb);
        lista.add(sm);
        fireTableDataChanged();
    }

    public void obrisiStavku(int row) {
        lista.remove(row);

        rb = 0;
        for (StavkaMasaze stavkaMasaze : lista) {
            stavkaMasaze.setRb(++rb);
        }

        fireTableDataChanged();

    }

    public StavkaMasaze vratiStavku(int row) {
        return lista.get(row);
    }

    public ArrayList<StavkaMasaze> getLista() {
        return lista;
    }

}
