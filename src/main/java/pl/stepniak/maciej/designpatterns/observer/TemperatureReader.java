package pl.stepniak.maciej.designpatterns.observer;

import java.util.List;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
interface TemperatureReader {

    public List<Measurement> read();
}
