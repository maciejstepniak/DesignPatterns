package pl.stepniak.maciej.designpatterns.decorator.accessory;

import pl.stepniak.maciej.designpatterns.decorator.bike.Bike;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class RearFender extends BikeAccessory {

    public RearFender(Bike bike) {
        this.bike = bike;
    }

    @Override
    public float getWeight() {
        return this.bike.getWeight() + 0.220f;
    }

}
