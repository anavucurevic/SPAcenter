/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.regijaTela;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.RegijaTela;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Ana
 */
public class SOGetAllRegijaTela extends AbstractSO {

    private ArrayList<RegijaTela> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof RegijaTela)) {
            throw new Exception("Prosledjeni objekat nije instanca klase RegijaTela!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> regijeTela = DBBroker.getInstance().select(ado);
        lista = (ArrayList<RegijaTela>) (ArrayList<?>) regijeTela;
    }

    public ArrayList<RegijaTela> getLista() {
        return lista;
    }

}
