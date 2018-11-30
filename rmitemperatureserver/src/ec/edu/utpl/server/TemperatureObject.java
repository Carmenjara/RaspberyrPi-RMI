package ec.edu.utpl.server;
import ec.edu.utpl.api.Temperatura;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Liz & Rocio
 */
public class TemperatureObject implements Temperatura {
    //Instancia de la clase GroveSensorTemperature  
    private GroveSensorTemperature temp = new GroveSensorTemperature();
    //Método para obtener la temperatura del metodo valTemp, mediante la instancia temp
    @Override
    public double getTemperature() throws RemoteException {
        try {
            return temp.valTemp();
        } catch (IOException ex) {
            Logger.getLogger(TemperatureObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    //Método para enviar valor a pantalla LCD del metodo sendSmsToLCD, mediante la instancia temp
    @Override
    public void smsToLCD(String smsToLCD) throws RemoteException {
        try {
            temp.sendSmsToLCD(smsToLCD);
        } catch (IOException ex) {
            Logger.getLogger(TemperatureObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
