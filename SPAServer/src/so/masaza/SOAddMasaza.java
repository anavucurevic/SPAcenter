/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.masaza;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Masaza;
import domain.StavkaMasaze;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Ana
 */
public class SOAddMasaza extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Masaza)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Masaza!");
        }

        Masaza m = (Masaza) ado;

        if (m.getStavkaMasaze().isEmpty()) {
            throw new Exception("Morate uneti barem jednu stavku masaze!");
        }

        ArrayList<Masaza> masaze = (ArrayList<Masaza>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Masaza masaza : masaze) {
            if (masaza.getNazivMasaze().equals(m.getNazivMasaze())) {
                throw new Exception("Vec postoji masaza sa tim nazivom!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long masazaID = tableKeys.getLong(1);
       
        Masaza m = (Masaza) ado;
        m.setMasazaID(masazaID);
        
     
        for (StavkaMasaze stavkaMasaze : m.getStavkaMasaze()) {
            stavkaMasaze.setMasaza(m);
            DBBroker.getInstance().insert(stavkaMasaze);
        }
        
    }

}
