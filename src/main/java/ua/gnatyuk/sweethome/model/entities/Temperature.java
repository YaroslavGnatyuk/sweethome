package ua.gnatyuk.sweethome.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "temperature")
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private Timestamp date;

    @Column(name="t_outside")
    private Float temperatureOutside;

    @Column(name = "t_inside_1")
    private Float temperatureInside1;

    @Column(name = "t_inside_2")
    private Float temperatureInside2;

    @Column(name = "bar_pressure")
    private Float barPressure;

    public Temperature() {

    }

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

    @Override
    public String toString() {
        return "Temperature{" +
                "id=" + id +
                ", date=" + date +
                ", temperatureOutside=" + temperatureOutside +
                ", temperatureInside1=" + temperatureInside1 +
                ", temperatureInside2=" + temperatureInside2 +
                ", barPressure=" + barPressure +
                '}';
    }
}
