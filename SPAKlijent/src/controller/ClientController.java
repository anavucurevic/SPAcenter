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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Ana
 */
public class ClientController {

    private static ClientController instance;

    public ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        return (Administrator) sendRequest(Operation.LOGIN, administrator);
    }

    public void addKlijent(Klijent klijent) throws Exception {
        sendRequest(Operation.ADD_KLIJENT, klijent);
    }
    
    public void addMasaza(Masaza masaza) throws Exception {
        sendRequest(Operation.ADD_MASAZA, masaza);
    }
    
    public void addRezervacija(Rezervacija rezervacija) throws Exception {
        sendRequest(Operation.ADD_REZERVACIJA, rezervacija);
    }
    
    public void addStavkaMasaze(StavkaMasaze stavkaMasaze) throws Exception {
        sendRequest(Operation.ADD_REZERVACIJA, stavkaMasaze);
    }
    
    public void addMaser(Maser  maser) throws Exception {
        sendRequest(Operation.ADD_MASER, maser);
    }
    
    public void deleteStavkaMasaze(StavkaMasaze stavkaMasaze) throws Exception {
        sendRequest(Operation.DELETE_REZERVACIJA, stavkaMasaze);
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
        sendRequest(Operation.DELETE_KLIJENT, klijent);
    }
    
    public void deleteMasaza(Masaza masaza) throws Exception {
        sendRequest(Operation.DELETE_MASAZA, masaza);
    }
    
    public void deleteRezervacija(Rezervacija rezervacija) throws Exception {
        sendRequest(Operation.DELETE_REZERVACIJA, rezervacija);
    }
    
    public void deleteMaser(Maser maser) throws Exception {
        sendRequest(Operation.DELETE_MASER, maser);
    }

    public void updateKlijent(Klijent klijent) throws Exception {
        sendRequest(Operation.UPDATE_KLIJENT, klijent);
    }
    
    public void updateMasaza(Masaza masaza) throws Exception {
        sendRequest(Operation.UPDATE_MASAZA, masaza);
    }
    
     public void updateMaser(Maser maser) throws Exception {
        sendRequest(Operation.UPDATE_MASER, maser);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        return (ArrayList<Administrator>) sendRequest(Operation.GET_ALL_ADMINISTRATOR, null);
    }
    
    public ArrayList<Klijent> getAllKlijent() throws Exception {
        return (ArrayList<Klijent>) sendRequest(Operation.GET_ALL_KLIJENT, null);
    }
    
    public ArrayList<Masaza> getAllMasaza() throws Exception {
        return (ArrayList<Masaza>) sendRequest(Operation.GET_ALL_MASAZA, null);
    }
    
    public ArrayList<Maser> getAllMaser() throws Exception {
        return (ArrayList<Maser>) sendRequest(Operation.GET_ALL_MASER, null);
    }
    
    public ArrayList<Rezervacija> getAllRezervacija() throws Exception {
        return (ArrayList<Rezervacija>) sendRequest(Operation.GET_ALL_REZERVACIJA, null);
    }

    public ArrayList<RegijaTela> getAllRegijaTela() throws Exception {
        return (ArrayList<RegijaTela>) sendRequest(Operation.GET_ALL_REGIJA_TELA, null);
    }
    
    public ArrayList<StavkaMasaze> getAllStavkaMasaze(Masaza m) throws Exception {
        return (ArrayList<StavkaMasaze>) sendRequest(Operation.GET_ALL_STAVKA_MASAZE, m);
    }
    
    
    
    private Object sendRequest(int operation, Object data) throws Exception {
        Request req = new Request(operation, data);
        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(req);
        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response res = (Response) in.readObject();
        if (res.getResponseStatus().equals(ResponseStatus.Error)) {
            throw res.getError();
        } else {
            return res.getData();
        }
    }
}
