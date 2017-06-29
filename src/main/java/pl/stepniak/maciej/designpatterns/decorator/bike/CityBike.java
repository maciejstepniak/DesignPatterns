package pl.stepniak.maciej.designpatterns.decorator.bike;

import pl.stepniak.maciej.designpatterns.decorator.BikeType;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class CityBike extends Bike {

    public CityBike() {
        this.type = BikeType.CITY;
    }

    @Override
    public float getWeight() {
        return 12.300f;
    }

}
