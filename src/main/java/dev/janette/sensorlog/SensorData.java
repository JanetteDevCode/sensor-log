package dev.janette.sensorlog;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "TIMESTAMP (6)")
    private Timestamp readingTime;

    private String device;

    private Double temperature;

    private Double humidity;

    private Double light;

    private Double sound;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getReadingTime() {
        return this.readingTime;
    }

    public void setReadingTime(Timestamp readingTime) {
        this.readingTime = readingTime;
    }

    public String getDevice() {
        return this.device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return this.humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getLight() {
        return this.light;
    }

    public void setLight(Double light) {
        this.light = light;
    }

    public Double getSound() {
        return this.sound;
    }

    public void setSound(Double sound) {
        this.sound = sound;
    }
}
