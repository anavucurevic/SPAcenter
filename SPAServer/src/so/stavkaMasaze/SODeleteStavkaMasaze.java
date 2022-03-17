/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stavkaMasaze;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.StavkaMasaze;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author Ana
 */
public class SODeleteStavkaMasaze extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof StavkaMasaze)) {
            throw new Exception("Prosledjeni objekat nije instanca klase StavkaMasaze!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().delete(ado);
    }

}
