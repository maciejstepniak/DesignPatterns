package pl.stepniak.maciej.designpatterns.observer;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public interface TemperatureObserver {

    /**
     * Default method creates local copy (values, not references) of
     * measurements list. (Deep copy)
     *
     * @param measurements List&lt;Measurement&gt;
     * @return copy of input list
     */
    default public List<Measurement> createLocalCopy(List<Measurement> measurements) {
        return measurements.stream().map(m -> new Measurement(m)).collect(Collectors.toList());
    }

    /**
     * Default method changes unit from degrees Celsius to destination Unit
     * (Kelvin or deg. Fahrenheit).
     *
     * @param measurements List&lt;Measurement&gt;
     * @param destUnit destination unit (Kelvin or deg. Fahrenheit)
     */
    default public void changeUnit(List<Measurement> measurements, TemperatureUnitEnum destUnit) {
        measurements.forEach((m) -> {
            m.setUnit(destUnit);
            float celsiusValue = m.getValue();
            m.setValue(convert(celsiusValue));
        });
    }

    public void update(List<Measurement> measurements);

    public float convert(float value);
}
