package pl.stepniak.maciej.designpatterns.observer;

import java.util.List;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public interface TemperaturePrinter {

    /**
     * Default method prints the list of measurements.
     *
     * @param measurements List&lt;Measurement&gt;
     */
    default public void printValues(List<Measurement> measurements) {
        measurements.stream().forEach(System.out::println);
    }
}
