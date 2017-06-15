package pl.stepniak.maciej.designpatterns.observer;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class KelvinObserver implements TemperatureObserver {

    private List<Measurement> measurements;

    @Override
    public void update(List<Measurement> measurements) {
        this.measurements = measurements.stream().map(m -> new Measurement(m)).collect(Collectors.toList());
        this.measurements.forEach(m -> m.setUnit(TemperatureUnitEnum.K));
        this.measurements.forEach((m) -> {
            float celsiusValue = m.getValue();
            m.setValue(convertCelsiusToKelvin(celsiusValue));
        });
        this.printValues(this.measurements);
    }

    private float convertCelsiusToKelvin(float value) {
        return value + 273.15f;
    }
}
