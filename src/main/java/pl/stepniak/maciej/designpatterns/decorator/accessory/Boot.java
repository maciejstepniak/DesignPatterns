package pl.stepniak.maciej.designpatterns.decorator.accessory;

import pl.stepniak.maciej.designpatterns.decorator.bike.Bike;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class Boot extends BikeAccessory {

    public Boot(Bike bike) {
        this.bike = bike;
    }

    @Override
    public float getWeight() {
        return this.bike.getWeight() + 0.680f;
    }

}
