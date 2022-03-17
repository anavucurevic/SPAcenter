/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Rezervacija;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ana
 */
public class TableModelRezervacije extends AbstractTableModel implements Runnable {

    private ArrayList<Rezervacija> lista;
    private String[] kolone = {"ID", "Klijent", "Maser", "Masaza", "Prostorija",
        "Datum i vreme pocetka", "Datum i vreme kraja"};
    private String parametar = "";

    public TableModelRezervacije() {
        try {
            lista = ClientController.getInstance().getAllRezervacija();
        } catch (Exception ex) {
            Logger.getLogger(TableModelRezervacije.class.getName()).log(Level.SEVERE, null, ex);
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
        Rezervacija r = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        
        switch (column) {
            case 0:
                return r.getRezervacijaID();
            case 1:
                return r.getKlijent();
            case 2:
                return r.getMaser();
            case 3:
                return r.getMasaza().getMasazaID();
            case 4:
                return r.getProstorija();
            case 5:
                return sdf.format(r.getDatumVremePocetka());
            case 6:
                return sdf.format(r.getDatumVremeKraja());

            default:
                return null;
        }
    }

    public Rezervacija getSelectedRezervacija(int row) {
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
            Logger.getLogger(TableModelRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllRezervacija();
            if (!parametar.equals("")) {
                ArrayList<Rezervacija> novaLista = new ArrayList<>();
                for (Rezervacija r : lista) {
                    if (r.getKlijent().getImeKlijenta().toLowerCase().contains(parametar.toLowerCase())
                            || r.getKlijent().getPrezimeKlijenta().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(r);
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
