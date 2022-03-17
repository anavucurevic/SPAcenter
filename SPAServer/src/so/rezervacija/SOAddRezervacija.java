/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezervacija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Rezervacija;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import so.AbstractSO;

/**
 *
 * @author Ana
 */
public class SOAddRezervacija extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Rezervacija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Rezervacija!");
        }

        Rezervacija r = (Rezervacija) ado;

        ArrayList<Rezervacija> rezervacije = (ArrayList<Rezervacija>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        for (Rezervacija rezervacija : rezervacije) {
            if (r.getMaser().getMaserID().equals(rezervacija.getMaser().getMaserID())
                    || r.getKlijent().getKlijentID().equals(rezervacija.getKlijent().getKlijentID())) {
//                String vremePocetka = sdf.format(rezervacija.getDatumVremePocetka());
//                String vremeKraja = sdf.format(rezervacija.getDatumVremeKraja());
//                
//                Date vremePocetkaPostojeceg = sdf.parse(vremePocetka);
//                Date vremeKrajaPostojeceg = sdf.parse(vremeKraja);

                Date vremePocetkaPostojeceg = rezervacija.getDatumVremePocetka();
                Date vremeKrajaPostojeceg = rezervacija.getDatumVremeKraja();

                if ((r.getDatumVremeKraja().after(vremePocetkaPostojeceg)
                        && r.getDatumVremeKraja().before(vremeKrajaPostojeceg))
                        || (r.getDatumVremeKraja().equals(vremePocetkaPostojeceg)
                        || r.getDatumVremeKraja().equals(vremeKrajaPostojeceg))
                        || (r.getDatumVremePocetka().before(vremePocetkaPostojeceg)
                        && r.getDatumVremeKraja().after(vremeKrajaPostojeceg))
                        || (r.getDatumVremePocetka().after(vremePocetkaPostojeceg)
                        && r.getDatumVremePocetka().before(vremeKrajaPostojeceg))) {
                    throw new Exception("Vec postoji zakazan termin izmedju "
                            + sdf.format(vremePocetkaPostojeceg) + " i "
                            + sdf.format(vremeKrajaPostojeceg) + " za klijenta "
                            + r.getKlijent() + " i/ili masera " + r.getMaser() + "!");
                }
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().insert(ado);
    }

}
