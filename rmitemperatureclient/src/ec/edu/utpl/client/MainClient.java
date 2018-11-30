/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.client;
import ec.edu.utpl.api.Temperatura;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.DelayQueue;
/**
 * @author Liz & Rocio
 */
public class MainClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, 
                                                            InterruptedException {
        String host = "172.17.21.50";
        String name = "Temperature";
        //Especifica el nombre del host donde se ejecuta el registro y el puerto  
        Registry registry = LocateRegistry.getRegistry(host, 1099);
        Temperatura tempObj = (Temperatura) registry.lookup(name);
        while (true) {
            double temp = tempObj.getTemperature();
            System.out.println(temp);
            if (Double.isNaN(temp)) {
                //Mensaje a LCD, cuando hay un fallo es la lectura del sensor DHT11
                tempObj.smsToLCD("Fallo lectura del sensor DHT11");
                System.out.println("Fallo lectura del sensor DHT11");
            } else if (temp > 16) {
                //Valor que se envía a pantalla LCD
                tempObj.smsToLCD("Temperatura elevada !!!");
                System.out.println("Temperatura elevada !!!");
            } else if (temp < 13) {
                //Valor que se envía a pantalla LCD
                tempObj.smsToLCD("Temperatura muy fría...");
                System.out.println("Temperatura muy fría...");
            } else {
                //Valor que se envía a pantalla LCD
                tempObj.smsToLCD("Temperatura normal...");
                System.out.println("Temperatura normal...");
            }
            //Tiempo en el que se vuelve a realizar una consulta al server
            Thread.sleep(9000);
        }
    }
}
