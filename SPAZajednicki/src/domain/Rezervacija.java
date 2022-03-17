/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ana
 */
public class Rezervacija extends AbstractDomainObject implements Serializable {

    private Long rezervacijaID;
    private Date datumVremePocetka;
    private Date datumVremeKraja;
    private String prostorija;
    private Klijent klijent;
    private Maser maser;
    private Masaza masaza;
    private Administrator administrator;

    public Rezervacija(Long rezervacijaID, Date datumVremePocetka, Date datumVremeKraja, String prostorija, Klijent klijent, Maser maser, Masaza masaza, Administrator administrator) {
        this.rezervacijaID = rezervacijaID;
        this.datumVremePocetka = datumVremePocetka;
        this.datumVremeKraja = datumVremeKraja;
        this.prostorija = prostorija;
        this.klijent = klijent;
        this.maser = maser;
        this.masaza = masaza;
        this.administrator = administrator;
    }

    public Rezervacija() {
    }

    @Override
    public String nazivTabele() {
        return " rezervacija ";
    }

    @Override
    public String alijas() {
        return " r ";
    }

    @Override
    public String join() {
        return " JOIN klijent k ON (k.klijentid = r.klijentid) "
                + "JOIN maser m ON (m.maserid = r.maserid) "
                + "JOIN masaza mas ON (mas.masazaid = r.masazaid) "
                + "JOIN administrator a ON (a.administratorid = r.administratorid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));
            
            Klijent k = new Klijent(rs.getLong("KlijentID"),
                    rs.getString("ImeKlijenta"), rs.getString("PrezimeKlijenta"),
                    rs.getString("Adresa"), rs.getString("Email"), rs.getString("BrojTelefona"));
            
            Maser m = new Maser(rs.getLong("MaserID"),
                    rs.getString("ImeMasera"), rs.getString("PrezimeMasera"),
                    rs.getString("Specijalnost"));
            
            Masaza mas = new Masaza(rs.getLong("MasazaID"),
                    rs.getString("NazivMasaze"), rs.getString("Opis"),
                    rs.getInt("TrajanjeMinuti"), rs.getDouble("Cena"), null);
            
            Rezervacija r = new Rezervacija(rs.getLong("RezervacijaID"), 
                    rs.getTimestamp("DatumVremePocetka"), rs.getTimestamp("DatumVremeKraja"), 
                    rs.getString("Prostorija"), k, m, mas, a);
            
            lista.add(r);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (DatumVremePocetka, DatumVremeKraja, Prostorija, KlijentID, "
                + "MaserID, MasazaID, AdministratorID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " RezervacijaID = " + rezervacijaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new Timestamp(datumVremePocetka.getTime()) + "', "
                + "'" + new Timestamp(datumVremeKraja.getTime()) + "', "
                + "'" + prostorija + "', " + klijent.getKlijentID() + ", "
                + maser.getMaserID() + ", " + masaza.getMasazaID() + ", "
                + administrator.getAdministratorID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String getByID() {
        return "";
    }

    public Long getRezervacijaID() {
        return rezervacijaID;
    }

    public void setRezervacijaID(Long rezervacijaID) {
        this.rezervacijaID = rezervacijaID;
    }

    public Date getDatumVremePocetka() {
        return datumVremePocetka;
    }

    public void setDatumVremePocetka(Date datumVremePocetka) {
        this.datumVremePocetka = datumVremePocetka;
    }

    public Date getDatumVremeKraja() {
        return datumVremeKraja;
    }

    public void setDatumVremeKraja(Date datumVremeKraja) {
        this.datumVremeKraja = datumVremeKraja;
    }

    public String getProstorija() {
        return prostorija;
    }

    public void setProstorija(String prostorija) {
        this.prostorija = prostorija;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Maser getMaser() {
        return maser;
    }

    public void setMaser(Maser maser) {
        this.maser = maser;
    }

    public Masaza getMasaza() {
        return masaza;
    }

    public void setMasaza(Masaza masaza) {
        this.masaza = masaza;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
}
