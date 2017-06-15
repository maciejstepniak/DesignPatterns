package pl.stepniak.maciej.designpatterns.observer;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class CelsiusObserver implements TemperatureObserver {

    private List<Measurement> measurements;

    @Override
    public void update(List<Measurement> measurements) {
        this.measurements = measurements.stream().map(m -> new Measurement(m)).collect(Collectors.toList());
        this.printValues(this.measurements);
    }
}