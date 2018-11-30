/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.server;
import ec.edu.utpl.api.Temperatura;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Liz & Rocio
 */
public class MainServer {

    public static void main(String[] args) throws RemoteException {
        String name = "Temperature";
        //registro en la maquina 
        Registry registry = LocateRegistry.createRegistry(1099);
        //Implementacion del objeto al servidor
        Temperatura temp = new TemperatureObject();

        //Stun para el objeto de servidor enn tiempo de ejecucion de RMI 
        //Implementa la comunicacion requerida con el obejeto servidor remoto.
        //El cliente va a autilizar este stub para invocar de forma transparente
        //el metodo en el objeto del servidor
        Temperatura stub = (Temperatura) UnicastRemoteObject.exportObject(temp, 0);

        //Se utiliza para vincular el nombre del stub
        registry.rebind(name, stub);
        System.out.println("Servidor Escuchando");
    }

}
