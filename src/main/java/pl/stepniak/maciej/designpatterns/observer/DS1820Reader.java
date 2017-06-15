package pl.stepniak.maciej.designpatterns.observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Data;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
@Data
public class DS1820Reader implements TemperatureProvider {

    private List<Measurement> measurements;
    private List<TemperatureObserver> temperatureObservers;

    public DS1820Reader() {
        this.temperatureObservers = new ArrayList<>();
        this.measurements = new ArrayList<>();
    }

    @Override
    public void addTemperatureObserver(TemperatureObserver temperatureObserver) {
        this.temperatureObservers.add(temperatureObserver);
    }

    @Override
    public void deleteTemperatureObserver(TemperatureObserver temperatureObserver) {
        int index = this.temperatureObservers.indexOf(temperatureObserver);
        if (index > 0) {
            this.temperatureObservers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        this.temperatureObservers.forEach(observer -> observer.update(this.measurements));
    }

    @Override
    public List<Measurement> read() {
        Process process = doMeasurementProcess();
        this.measurements = readMeasurements(process);
        process.destroy();
        notifyObservers();
        return this.measurements;
    }

    private Process doMeasurementProcess() {
        Process process = null;
        try {
            ProcessBuilder pb = new ProcessBuilder("python3", "/home/maciek/Skrypty/ds1820read.py");
            process = pb.start();
        } catch (IOException ex) {
            Logger.getLogger(DS1820Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return process;
    }

    private List<Measurement> readMeasurements(Process process) throws NumberFormatException {
        List<Measurement> measurements = new ArrayList<>();
        try (BufferedReader in
                = new BufferedReader(new InputStreamReader(process.getInputStream()))) {

            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                if (errorOccured(inputLine)) {
                    System.err.println("Błąd odczytu temperatury z czujnika DS1820.");
                } else {
                    measurements.add(prepareMeasurementObject(inputLine));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DS1820Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return measurements;
    }

    private static boolean errorOccured(String inputLine) {
        return inputLine.contains("error");
    }

    private Measurement prepareMeasurementObject(String inputLine) throws NumberFormatException {
        Measurement measurement = new Measurement(LocalDateTime.now());
        String[] splitedLine = inputLine.split(";");
        measurement.setSensorId(splitedLine[0]);
        measurement.setValue(Float.parseFloat(splitedLine[1]));
        measurement.setUnit(TemperatureUnitEnum.C);
        return measurement;
    }
}
