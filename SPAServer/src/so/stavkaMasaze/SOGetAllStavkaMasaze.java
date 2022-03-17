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
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Ana
 */
public class SOGetAllStavkaMasaze extends AbstractSO {

    private ArrayList<StavkaMasaze> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof StavkaMasaze)) {
            throw new Exception("Prosledjeni objekat nije instanca klase StavkaMasaze!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> stavkeMasaze = DBBroker.getInstance().select(ado);
        lista = (ArrayList<StavkaMasaze>) (ArrayList<?>) stavkeMasaze;
    }

    public ArrayList<StavkaMasaze> getLista() {
        return lista;
    }

}
