/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Liz & Rocio
 */
public interface Temperatura extends Remote{
    //Obtiene el valor de la temperatura
    double getTemperature() throws RemoteException;
    //Envía el valor a pantalla LCD
    void smsToLCD(String smsToLCD) throws RemoteException;
}


