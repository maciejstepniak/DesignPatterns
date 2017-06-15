package pl.stepniak.maciej.designpatterns.observer;

import java.util.List;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
interface TemperatureProvider {

    public void addTemperatureObserver(TemperatureObserver temperatureObserver);

    public void deleteTemperatureObserver(TemperatureObserver temperatureObserver);

    public void notifyObservers();

    public List<Measurement> read();

}
