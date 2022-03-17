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
public class StavkaMasaze extends AbstractDomainObject implements Serializable {

    private Masaza masaza;
    private int rb;
    private int trajanjeMinuti;
    private String tehnika;
    private RegijaTela regija;

    public StavkaMasaze(Masaza masaza, int rb, int trajanjeMinuti, String tehnika, RegijaTela regija) {
        this.masaza = masaza;
        this.rb = rb;
        this.trajanjeMinuti = trajanjeMinuti;
        this.tehnika = tehnika;
        this.regija = regija;
    }

    public StavkaMasaze() {
    }

    @Override
    public String nazivTabele() {
        return " stavkaMasaze ";
    }

    @Override
    public String alijas() {
        return " sm ";
    }

    @Override
    public String join() {
        return " JOIN masaza m ON (m.masazaid = sm.masazaid) "
                + "JOIN regijaTela rt ON (rt.regijaID = sm.regijaID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            Masaza m = new Masaza(rs.getLong("MasazaID"),
                    rs.getString("NazivMasaze"), rs.getString("Opis"),
                    rs.getInt("TrajanjeMinuti"), rs.getDouble("Cena"), null);

            RegijaTela rt = new RegijaTela(rs.getLong("RegijaID"),
                    rs.getString("NazivRegije"));

            StavkaMasaze sm = new StavkaMasaze(m, rs.getInt("Rb"),
                    rs.getInt("TrajanjeMinuti"), rs.getString("Tehnika"), rt);

            lista.add(sm);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (MasazaID, Rb, TrajanjeMinuti, Tehnika, RegijaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " MasazaID = " + masaza.getMasazaID();
    }

    @Override
    public String vrednostiZaInsert() {
        return masaza.getMasazaID() + ", " + rb + ", " + trajanjeMinuti + ", '" + tehnika + "', "
                + regija.getRegijaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String getByID() {
        return " WHERE m.masazaid = " + masaza.getMasazaID();
    }

    public Masaza getMasaza() {
        return masaza;
    }

    public void setMasaza(Masaza masaza) {
        this.masaza = masaza;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getTrajanjeMinuti() {
        return trajanjeMinuti;
    }

    public void setTrajanjeMinuti(int trajanjeMinuti) {
        this.trajanjeMinuti = trajanjeMinuti;
    }

    public String getTehnika() {
        return tehnika;
    }

    public void setTehnika(String tehnika) {
        this.tehnika = tehnika;
    }

    public RegijaTela getRegija() {
        return regija;
    }

    public void setRegija(RegijaTela regija) {
        this.regija = regija;
    }
}
