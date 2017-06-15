package pl.stepniak.maciej.designpatterns.observer;

import java.util.List;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class ObserverRunner {

    public static void main(String args[]) {
        System.out.println("Wzorzec projektowy Obserwator");
        TemperatureObserver celsiusObserver = new CelsiusObserver();
        TemperatureObserver kelvinObserver = new KelvinObserver();
        TemperatureObserver fahrenheitObserver = new FahrenheitObserver();

        TemperatureProvider reader = new DS1820Reader();
        reader.addTemperatureObserver(kelvinObserver);
        reader.addTemperatureObserver(celsiusObserver);
        reader.addTemperatureObserver(fahrenheitObserver);

        List<Measurement> measurements = reader.read();
        System.out.println("\nOdczytana wartość:");
        measurements.forEach(System.out::println);

    }
}
