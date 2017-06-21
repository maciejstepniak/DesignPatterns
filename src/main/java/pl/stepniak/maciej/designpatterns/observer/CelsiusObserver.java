package pl.stepniak.maciej.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class CelsiusObserver implements TemperatureObserver, TemperaturePrinter {

    private List<Measurement> measurements = new ArrayList<>();

    @Override
    public void update(List<Measurement> measurements) {
        this.measurements = measurements.stream().map(m -> new Measurement(m)).collect(Collectors.toList());
        this.printValues(this.measurements);
    }

    @Override
    public float convert(float value) {
        return (float) (Math.round(value * 100.0) / 100.0);
    }
}
