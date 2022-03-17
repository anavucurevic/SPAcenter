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
public class Maser extends AbstractDomainObject implements Serializable {
    
    private Long maserID;
    private String imeMasera;
    private String prezimeMasera;
    private String specijalnost;

    public Maser(Long maserID, String imeMasera, String prezimeMasera, String specijalnost) {
        this.maserID = maserID;
        this.imeMasera = imeMasera;
        this.prezimeMasera = prezimeMasera;
        this.specijalnost = specijalnost;
    }

    @Override
    public String toString() {
        return imeMasera + " " + prezimeMasera;
    }

    public Maser() {
    }
    
    @Override
    public String nazivTabele() {
        return " maser ";
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
            Maser m = new Maser(rs.getLong("MaserID"),
                    rs.getString("ImeMasera"), rs.getString("PrezimeMasera"),
                    rs.getString("Specijalnost"));

            lista.add(m);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(ImeMasera, PrezimeMasera, Specijalnost)";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " MaserID = " + maserID;
    }

    @Override
    public String vrednostiZaInsert() {
       return "'" + imeMasera + "', '" + prezimeMasera + "', "
                + "'" + specijalnost + "' ";
    }
 
    @Override
    public String vrednostiZaUpdate() {
      return " ImeMasera = '" + imeMasera + "', PrezimeMasera =  '" + prezimeMasera + "', Specijalnost =  "
                + "'" + specijalnost + "' ";
    }

    @Override
    public String getByID() {
        return "";
    }

    public Long getMaserID() {
        return maserID;
    }

    public void setMaserID(Long maserID) {
        this.maserID = maserID;
    }

    public String getImeMasera() {
        return imeMasera;
    }

    public void setImeMasera(String imeMasera) {
        this.imeMasera = imeMasera;
    }

    public String getPrezimeMasera() {
        return prezimeMasera;
    }

    public void setPrezimeMasera(String prezimeMasera) {
        this.prezimeMasera = prezimeMasera;
    }

    public String getSpecijalnost() {
        return specijalnost;
    }

    public void setSpecijalnost(String specijalnost) {
        this.specijalnost = specijalnost;
    }
}
