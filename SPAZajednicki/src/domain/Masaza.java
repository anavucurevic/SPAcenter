/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ana
 */
public class Masaza extends AbstractDomainObject implements Serializable  {
    
    private Long masazaID;
    private String nazivMasaze;
    private String opis;
    private int trajanjeMinuti;
    private double cena;
    private ArrayList<StavkaMasaze> stavkaMasaze;

    @Override
    public String toString() {
        return nazivMasaze + " (Trajanje: " + trajanjeMinuti + "min, Cena: " + cena + "din)"; 
    }

    public Masaza(Long masazaID, String nazivMasaze, String opis, int trajanjeMinuti, double cena, ArrayList<StavkaMasaze> stavkaMasaze) {
        this.masazaID = masazaID;
        this.nazivMasaze = nazivMasaze;
        this.opis = opis;
        this.trajanjeMinuti = trajanjeMinuti;
        this.cena = cena;
        this.stavkaMasaze = stavkaMasaze;
    }

    public Masaza() {
    }
    
    @Override
    public String nazivTabele() {
        return " masaza ";
    }

    @Override
    public String alijas() {
        return " m ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Masaza m = new Masaza(rs.getLong("MasazaID"),
                    rs.getString("NazivMasaze"), rs.getString("Opis"),
                    rs.getInt("TrajanjeMinuti"), rs.getDouble("Cena"), null);

            lista.add(m);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (NazivMasaze, Opis, TrajanjeMinuti, Cena) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " MasazaID = " + masazaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivMasaze + "', '" + opis + "', "
                + trajanjeMinuti + ", " + cena;
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Opis = '" + opis + "', TrajanjeMinuti = " + trajanjeMinuti + ", "
                + "Cena = " + cena + " ";
    }

    @Override
    public String getByID() {
        return "";
    }

    public Long getMasazaID() {
        return masazaID;
    }

    public void setMasazaID(Long masazaID) {
        this.masazaID = masazaID;
    }

    public String getNazivMasaze() {
        return nazivMasaze;
    }

    public void setNazivMasaze(String nazivMasaze) {
        this.nazivMasaze = nazivMasaze;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getTrajanjeMinuti() {
        return trajanjeMinuti;
    }

    public void setTrajanjeMinuti(int trajanjeMinuti) {
        this.trajanjeMinuti = trajanjeMinuti;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public ArrayList<StavkaMasaze> getStavkaMasaze() {
        return stavkaMasaze;
    }

    public void setStavkaMasaze(ArrayList<StavkaMasaze> stavkaMasaze) {
        this.stavkaMasaze = stavkaMasaze;
    }

}
