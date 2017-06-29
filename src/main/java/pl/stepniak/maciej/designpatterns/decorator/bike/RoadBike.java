package pl.stepniak.maciej.designpatterns.decorator.bike;

import pl.stepniak.maciej.designpatterns.decorator.BikeType;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class RoadBike extends Bike {

    public RoadBike() {
        this.type = BikeType.ROAD;
    }

    @Override
    public float getWeight() {
        return 8.200f;
    }

}
