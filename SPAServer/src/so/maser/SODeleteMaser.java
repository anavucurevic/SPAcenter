/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.maser;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Maser;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author Ana
 */
public class SODeleteMaser extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Maser)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Maser!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().delete(ado);
    }

}
