package pl.stepniak.maciej.designpatterns.decorator;

import pl.stepniak.maciej.designpatterns.decorator.accessory.BicycleBell;
import pl.stepniak.maciej.designpatterns.decorator.accessory.Boot;
import pl.stepniak.maciej.designpatterns.decorator.accessory.BottleCage;
import pl.stepniak.maciej.designpatterns.decorator.accessory.FrontFender;
import pl.stepniak.maciej.designpatterns.decorator.accessory.RearFender;
import pl.stepniak.maciej.designpatterns.decorator.bike.Bike;
import pl.stepniak.maciej.designpatterns.decorator.bike.CityBike;
import pl.stepniak.maciej.designpatterns.decorator.bike.RoadBike;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class DecoratorRunner {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Wzorzec projektowy Dekorator");

        Bike cityBike = new CityBike();
        System.out.println("Waga roweru miejskiego bez akcesoriów: " + cityBike.getWeight());

        cityBike = new Boot(cityBike);
        cityBike = new RearFender(cityBike);
        cityBike = new FrontFender(cityBike);
        cityBike = new BicycleBell(cityBike);

        System.out.println("Waga roweru miejskiego z akcesoriami: " + cityBike.getWeight());

        Bike roadBike = new RoadBike();
        System.out.println("Waga roweru szosowego bez akcesoriów: " + roadBike.getWeight());

        roadBike = new BottleCage(roadBike);

        System.out.println("Waga roweru szosowego z akcesoriami: " + roadBike.getWeight());
    }
}
