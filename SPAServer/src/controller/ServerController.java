/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Administrator;
import domain.Klijent;
import domain.Masaza;
import domain.Maser;
import domain.RegijaTela;
import domain.Rezervacija;
import domain.StavkaMasaze;
import java.util.ArrayList;
import so.AbstractSO;
import so.administrator.SOGetAllAdministrator;
import so.klijent.SOAddKlijent;
import so.klijent.SODeleteKlijent;
import so.klijent.SOGetAllKlijent;
import so.klijent.SOUpdateKlijent;
import so.masaza.SOAddMasaza;
import so.masaza.SODeleteMasaza;
import so.masaza.SOGetAllMasaza;
import so.masaza.SOUpdateMasaza;
import so.maser.SOAddMaser;
import so.maser.SODeleteMaser;
import so.maser.SOGetAllMaser;
import so.maser.SOUpdateMaser;
import so.regijaTela.SOGetAllRegijaTela;
import so.rezervacija.SOAddRezervacija;
import so.rezervacija.SODeleteRezervacija;
import so.rezervacija.SOGetAllRezervacija;
import so.stavkaMasaze.SODeleteStavkaMasaze;
import so.stavkaMasaze.SOGetAllStavkaMasaze;

/**
 *
 * @author Ana
 */
public class ServerController {

    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public void addKlijent(Klijent klijent) throws Exception {
        AbstractSO aso = new SOAddKlijent();
        aso.templateExecute(klijent);
    }
    
    public void addMasaza(Masaza masaza) throws Exception {
        AbstractSO aso = new SOAddMasaza();
        aso.templateExecute(masaza);
    }
    
    public void addRezervacija(Rezervacija rezervacija) throws Exception {
        AbstractSO aso = new SOAddRezervacija();
        aso.templateExecute(rezervacija);
    }
    
    public void addStavkaMasaze(StavkaMasaze stavkaMasaze) throws Exception {
        AbstractSO aso = new SOAddRezervacija();
        aso.templateExecute(stavkaMasaze);
    }
    
     public void addMaser(Maser maser) throws Exception {
        AbstractSO aso = new SOAddMaser();
        aso.templateExecute(maser);
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
        AbstractSO aso = new SODeleteKlijent();
        aso.templateExecute(klijent);
    }
    
    public void deleteStavkaMasaze(StavkaMasaze stavkaMasaze) throws Exception {
        AbstractSO aso = new SODeleteStavkaMasaze();
        aso.templateExecute(stavkaMasaze);
    }
    
    public void deleteMasaza(Masaza masaza) throws Exception {
        AbstractSO aso = new SODeleteMasaza();
        aso.templateExecute(masaza);
    }
    
    public void deleteRezervacija(Rezervacija rezervacija) throws Exception {
        AbstractSO aso = new SODeleteRezervacija();
        aso.templateExecute(rezervacija);
    }
    
     public void deleteMaser(Maser maser) throws Exception {
        AbstractSO aso = new SODeleteMaser();
        aso.templateExecute(maser);
    }
    

    public void updateKlijent(Klijent klijent) throws Exception {
        AbstractSO aso = new SOUpdateKlijent();
        aso.templateExecute(klijent);
    }
    
    public void updateMasaza(Masaza masaza) throws Exception {
        AbstractSO aso = new SOUpdateMasaza();
        aso.templateExecute(masaza);
    }
    
     public void updateMaser(Maser maser) throws Exception {
        AbstractSO aso = new SOUpdateMaser();
        aso.templateExecute(maser);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        SOGetAllAdministrator so = new SOGetAllAdministrator();
        so.templateExecute(new Administrator());
        return so.getLista(); 
    }
    
    public ArrayList<Klijent> getAllKlijent() throws Exception {
        SOGetAllKlijent so = new SOGetAllKlijent();
        so.templateExecute(new Klijent());
        return so.getLista();
    }
    
    public ArrayList<Masaza> getAllMasaza() throws Exception {
        SOGetAllMasaza so = new SOGetAllMasaza();
        so.templateExecute(new Masaza());
        return so.getLista();
    }
    
    public ArrayList<Maser> getAllMaser() throws Exception {
        SOGetAllMaser so = new SOGetAllMaser();
        so.templateExecute(new Maser());
        return so.getLista();
    }
    
    public ArrayList<RegijaTela> getAllRegijaTela() throws Exception {
        SOGetAllRegijaTela so = new SOGetAllRegijaTela();
        so.templateExecute(new RegijaTela());
        return so.getLista();
    }
    
    public ArrayList<Rezervacija> getAllRezervacija() throws Exception {
        SOGetAllRezervacija so = new SOGetAllRezervacija();
        so.templateExecute(new Rezervacija());
        return so.getLista();
    }
    
    public ArrayList<StavkaMasaze> getAllStavkaMasaze(Masaza m) throws Exception {
        SOGetAllStavkaMasaze so = new SOGetAllStavkaMasaze();
        
        StavkaMasaze sm = new StavkaMasaze();
        sm.setMasaza(m);
        
        so.templateExecute(sm);
        return so.getLista();
    }

}
