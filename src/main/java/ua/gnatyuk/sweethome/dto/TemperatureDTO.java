package ua.gnatyuk.sweethome.dto;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Timestamp;

@ToString(exclude="id")
@EqualsAndHashCode(exclude="id")
public class TemperatureDTO {
    private Integer id;
    private Timestamp date;
    private Float temperatureOutside;
    private Float temperatureInside1;
    private Float temperatureInside2;
    private Float barPressure;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Float getTemperatureOutside() {
        return temperatureOutside;
    }

    public void setTemperatureOutside(Float temperatureOutside) {
        this.temperatureOutside = temperatureOutside;
    }

    public Float getTemperatureInside1() {
        return temperatureInside1;
    }

    public void setTemperatureInside1(Float temperatureInside1) {
        this.temperatureInside1 = temperatureInside1;
    }

    public Float getTemperatureInside2() {
        return temperatureInside2;
    }

    public void setTemperatureInside2(Float temperatureInside2) {
        this.temperatureInside2 = temperatureInside2;
    }

    public Float getBarPressure() {
        return barPressure;
    }

    public void setBarPressure(Float barPressure) {
        this.barPressure = barPressure;
    }
}
