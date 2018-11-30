package ec.edu.utpl.server;
import com.pi4j.wiringpi.Gpio;
import java.io.IOException;
import java.util.Random;
import org.iot.raspberry.grovepi.GrovePi;
import org.iot.raspberry.grovepi.devices.GroveRgbLcd;
import org.iot.raspberry.grovepi.devices.GroveTemperatureAndHumiditySensor;
import org.iot.raspberry.grovepi.pi4j.GrovePi4J;
/**
 * @author Liz & Rocio
 */
public class GroveSensorTemperature {
    //Variable tipo GrovePi
    GrovePi grovePi;
    //Método para obtener la temperatura
    public double valTemp() throws IOException {
        grovePi = new GrovePi4J();
        GroveTemperatureAndHumiditySensor dht
                = new GroveTemperatureAndHumiditySensor(grovePi, 0,
                        GroveTemperatureAndHumiditySensor.Type.DHT11);
        //Imprime temperatura
        System.out.println(dht.get().getTemperature());
        //Arreglo de valores supuestos de temperatura
        int arraytemp[] = {10, 11, 12, 13, 14, 15, 16, 17};
        int tempVal = arraytemp[new Random().nextInt(arraytemp.length)];

        //retorna el valor de la temperatura
        //return dht.get().getTemperature();
        return tempVal;
    }
    //Método para enviar valor a pantalla LCD
    public void sendSmsToLCD(String sms) throws IOException {
        GroveRgbLcd lcd = grovePi.getLCD();
        int[][] colors = new int[][]{
            {50, 255, 30},
            {15, 88, 245},
            {248, 52, 100},
            {48, 56, 190},
            {178, 25, 180},
            {210, 210, 210}
        };
        int[] color = colors[new Random().nextInt(colors.length)];
        lcd.setRGB(color[0], color[1], color[2]);
        //Imprime alerta de temperatura
        System.out.printf(sms);
        //Se establece el nombre en la pantalla
        lcd.setText(sms);
    }
}

