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
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Ana
 */
public class SOGetAllMaser extends AbstractSO {

    private ArrayList<Maser> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Maser)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Maser!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> maseri = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Maser>) (ArrayList<?>) maseri;
    }

    public ArrayList<Maser> getLista() {
        return lista;
    }

}
