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
public class RegijaTela extends AbstractDomainObject implements Serializable  {
    
    private Long regijaID;
    private String nazivRegije;

    @Override
    public String toString() {
        return nazivRegije;
    }

    public RegijaTela(Long regijaID, String nazivRegije) {
        this.regijaID = regijaID;
        this.nazivRegije = nazivRegije;
    }

    public RegijaTela() {
    }

    @Override
    public String nazivTabele() {
        return " regijaTela ";
    }

    @Override
    public String alijas() {
        return " rt ";
    }

    @Override
    public String join() {
        return " ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
           
            RegijaTela rt = new RegijaTela(rs.getLong("RegijaID"),
                    rs.getString("NazivRegije"));

            lista.add(rt);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " RegijaID = " + regijaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String getByID() {
        return "";
    }

    public Long getRegijaID() {
        return regijaID;
    }

    public void setRegijaID(Long regijaID) {
        this.regijaID = regijaID;
    }

    public String getNazivRegije() {
        return nazivRegije;
    }

    public void setNazivRegije(String nazivRegije) {
        this.nazivRegije = nazivRegije;
    }

}
