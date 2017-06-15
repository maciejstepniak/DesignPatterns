package pl.stepniak.maciej.designpatterns.observer;

import java.util.List;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public interface TemperatureObserver {

    default public void printValues(List<Measurement> measurements) {
        measurements.stream().forEach(System.out::println);
    }

    public void update(List<Measurement> measurements);
}
