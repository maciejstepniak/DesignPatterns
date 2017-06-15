package pl.stepniak.maciej.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class FahrenheitObserver implements TemperatureObserver {

    private List<Measurement> measurements = new ArrayList<>();

    @Override
    public void update(List<Measurement> measurements) {
        this.measurements = measurements.stream().map(m -> new Measurement(m)).collect(Collectors.toList());
        this.measurements.forEach(m -> m.setUnit(TemperatureUnitEnum.F));
        this.measurements.forEach((m) -> {
            float celsiusValue = m.getValue();
            m.setValue(convertCelsiusToFahrenheit(celsiusValue));
        });
        this.printValues(this.measurements);

    }

    private float convertCelsiusToFahrenheit(float value) {
        return (value * 1.8f) + 32;
    }
}
