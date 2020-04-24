package dev.janette.sensorlog;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Basic
    private Timestamp timestamp;

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

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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
