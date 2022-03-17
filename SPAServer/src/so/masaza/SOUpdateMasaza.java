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
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author Ana
 */
public class SOUpdateMasaza extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Masaza)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Masaza!");
        }
        
        Masaza m = (Masaza) ado;

        if (m.getStavkaMasaze().isEmpty()) {
            throw new Exception("Morate uneti barem jednu stavku masaze!");
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        
      
        DBBroker.getInstance().update(ado);
        
        Masaza m = (Masaza) ado;
      
        DBBroker.getInstance().delete(m.getStavkaMasaze().get(0));
        
       
        for (StavkaMasaze stavkaMasaze : m.getStavkaMasaze()) {
            DBBroker.getInstance().insert(stavkaMasaze);
        }
        
    }

}
