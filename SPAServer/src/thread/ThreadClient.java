/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domain.Administrator;
import domain.Klijent;
import domain.Masaza;
import domain.Maser;
import domain.RegijaTela;
import domain.Rezervacija;
import domain.StavkaMasaze;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Ana
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request req = (Request) in.readObject();
                Response res = handleRequest(req);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request req) {
        Response res = new Response(null, null, ResponseStatus.Success);
        try {
            switch (req.getOperation()) {
                case Operation.ADD_KLIJENT:
                    ServerController.getInstance().addKlijent((Klijent) req.getData());
                    break;
                case Operation.ADD_MASAZA:
                    ServerController.getInstance().addMasaza((Masaza) req.getData());
                    break;
                case Operation.ADD_STAVKA_MASAZE:
                    ServerController.getInstance().addStavkaMasaze((StavkaMasaze) req.getData());
                    break;
                case Operation.ADD_REZERVACIJA:
                    ServerController.getInstance().addRezervacija((Rezervacija) req.getData());
                    break;
                     case Operation.ADD_MASER:
                    ServerController.getInstance().addMaser((Maser) req.getData());
                    break;
                case Operation.DELETE_KLIJENT:
                    ServerController.getInstance().deleteKlijent((Klijent) req.getData());
                    break;
                case Operation.DELETE_MASAZA:
                    ServerController.getInstance().deleteMasaza((Masaza) req.getData());
                    break;
                case Operation.DELETE_REZERVACIJA:
                    ServerController.getInstance().deleteRezervacija((Rezervacija) req.getData());
                    break;
                case Operation.DELETE_STAVKA_MASAZE:
                    ServerController.getInstance().deleteStavkaMasaze((StavkaMasaze) req.getData());
                    break;
                     case Operation.DELETE_MASER:
                    ServerController.getInstance().deleteMaser((Maser) req.getData());
                    break;
                case Operation.UPDATE_KLIJENT:
                    ServerController.getInstance().updateKlijent((Klijent) req.getData());
                    break;
                case Operation.UPDATE_MASAZA:
                    ServerController.getInstance().updateMasaza((Masaza) req.getData());
                    break;
                     case Operation.UPDATE_MASER:
                    ServerController.getInstance().updateMaser((Maser) req.getData());
                    break;
                case Operation.GET_ALL_ADMINISTRATOR:
                    res.setData(ServerController.getInstance().getAllAdministrator());
                    break;
                case Operation.GET_ALL_KLIJENT:
                    res.setData(ServerController.getInstance().getAllKlijent());
                    break;
                case Operation.GET_ALL_MASAZA:
                    res.setData(ServerController.getInstance().getAllMasaza());
                    break;
                case Operation.GET_ALL_MASER:
                    res.setData(ServerController.getInstance().getAllMaser());
                    break;
                case Operation.GET_ALL_STAVKA_MASAZE:
                    res.setData(ServerController.getInstance().getAllStavkaMasaze((Masaza) req.getData()));
                    break;
                case Operation.GET_ALL_REGIJA_TELA:
                    res.setData(ServerController.getInstance().getAllRegijaTela());
                    break;
                case Operation.GET_ALL_REZERVACIJA:
                    res.setData(ServerController.getInstance().getAllRezervacija());
                    break;
                case Operation.LOGIN:
                    ArrayList<Administrator> lista = ServerController.getInstance().getAllAdministrator();
                    Administrator a = (Administrator) req.getData();
                    for (Administrator administrator : lista) {
                        if (administrator.getUsername().equals(a.getUsername())
                                && administrator.getPassword().equals(a.getPassword())) {
                            res.setData(administrator);
                        }
                    }
                    if (res.getData() == null) {
                        throw new Exception("Ne postoji administrator sa tim kredencijalima.");
                    } else {
                        break;
                    }
                default:
                    return null;
            }
        } catch (Exception e) {
            res.setError(e);
            res.setResponseStatus(ResponseStatus.Error);
        }
        return res;
    }

}
