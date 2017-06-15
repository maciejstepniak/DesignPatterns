package pl.stepniak.maciej.designpatterns.observer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
@Data
@NoArgsConstructor
class Measurement {

    private static final char DEGREE = (char) 176;

    private LocalDateTime dateTime;
    private String sensorId;
    private float value;
    private TemperatureUnitEnum unit;

    public Measurement(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Measurement(Measurement measurement) {
        this.dateTime = measurement.getDateTime();
        this.sensorId = measurement.getSensorId();
        this.value = measurement.getValue();
        this.unit = measurement.getUnit();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = this.dateTime.format(formatter);

        StringBuilder sb = new StringBuilder(formattedDateTime);
        sb.append(" (").append(this.sensorId).append(")").append(": ").append(this.value).append(" ");
        switch (this.unit) {
            case C: {
                sb.append(DEGREE).append("C");
                break;
            }
            case K: {
                sb.append("K");
                break;
            }
            case F: {
                sb.append(DEGREE).append("F");
                break;
            }
            default: {
                sb.append(DEGREE).append("C");
            }
        }
        return sb.toString();
    }
}
