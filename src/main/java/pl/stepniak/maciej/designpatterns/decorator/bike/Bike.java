package pl.stepniak.maciej.designpatterns.decorator.bike;

import pl.stepniak.maciej.designpatterns.decorator.BikeType;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public abstract class Bike {

    protected BikeType type = BikeType.UNKNOWN;

    public BikeType getType() {
        return this.type;
    }

    public abstract float getWeight();
}
