/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

/**
 *
 * @author Ana
 */
public interface Operation {

    public static final int LOGIN = 0;

    public static final int GET_ALL_ADMINISTRATOR = 1;

    public static final int ADD_KLIJENT = 2;
    public static final int DELETE_KLIJENT = 3;
    public static final int UPDATE_KLIJENT = 4;
    public static final int GET_ALL_KLIJENT = 5;

    public static final int ADD_REZERVACIJA = 6;
    public static final int DELETE_REZERVACIJA = 7;
    public static final int GET_ALL_REZERVACIJA = 8;
    
    public static final int GET_ALL_MASER = 9;

    public static final int ADD_MASAZA = 10;
    public static final int DELETE_MASAZA = 11;
    public static final int UPDATE_MASAZA = 12;
    public static final int GET_ALL_MASAZA = 13;

    public static final int ADD_STAVKA_MASAZE = 14;
    public static final int DELETE_STAVKA_MASAZE = 15;
    public static final int GET_ALL_STAVKA_MASAZE = 16;
    
    public static final int GET_ALL_REGIJA_TELA = 17;
    
    public static final int ADD_MASER=18;
    public static final int DELETE_MASER=19;
    public static final int UPDATE_MASER=20;

}
