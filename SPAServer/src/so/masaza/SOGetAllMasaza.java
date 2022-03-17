/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.masaza;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Masaza;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Ana
 */
public class SOGetAllMasaza extends AbstractSO {

    private ArrayList<Masaza> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Masaza)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Masaza!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> masaze = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Masaza>) (ArrayList<?>) masaze;
    }

    public ArrayList<Masaza> getLista() {
        return lista;
    }

}
