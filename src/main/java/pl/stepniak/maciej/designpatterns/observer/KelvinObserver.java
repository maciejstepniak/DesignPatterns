package pl.stepniak.maciej.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class KelvinObserver implements TemperatureObserver, TemperaturePrinter {

    private List<Measurement> measurements = new ArrayList<>();

    @Override
    public void update(List<Measurement> measurements) {
        this.measurements = createLocalCopy(measurements);
        changeUnit(this.measurements, TemperatureUnitEnum.K);
        printValues(this.measurements);
    }

    @Override
    public float convert(float value) {
        float result = value + 273.15f;
        return (float) (Math.round(result * 100.0) / 100.0);
    }
}
