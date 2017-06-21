package pl.stepniak.maciej.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class FahrenheitObserver implements TemperatureObserver, TemperaturePrinter {

    private List<Measurement> measurements = new ArrayList<>();

    @Override
    public void update(List<Measurement> measurements) {
        this.measurements = createLocalCopy(measurements);
        changeUnit(this.measurements, TemperatureUnitEnum.F);
        printValues(this.measurements);
    }

    @Override
    public float convert(float value) {
        float result = (value * 1.8f) + 32;
        return (float) (Math.round(result * 100.0) / 100.0);
    }
}
