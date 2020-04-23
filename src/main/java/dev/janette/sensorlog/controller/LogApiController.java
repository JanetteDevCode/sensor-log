package dev.janette.sensorlog.controller;

import dev.janette.sensorlog.SensorData;
import dev.janette.sensorlog.SensorDataRepository;
import dev.janette.sensorlog.error.KeyNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping(path="/api/v1")
public class LogApiController {
    @Autowired
    private SensorDataRepository sensorDataRepository;

    @Autowired
    private Environment env;

    @PostMapping(path="/add")
    public SensorData addNewEntry(@RequestParam String device,
                                  @RequestParam Double temperature,
                                  @RequestParam Double humidity,
                                  @RequestParam Double light,
                                  @RequestParam Double sound,
                                  @RequestParam String key) {
        final String POST_KEY = env.getProperty("sensor-log.apiPostKey");

        if (!(key.equals(POST_KEY))) {
            throw new KeyNotValidException();
        }

        SensorData sensorData = new SensorData();
        sensorData.setDevice(device);
        sensorData.setTemperature(temperature);
        sensorData.setHumidity(humidity);
        sensorData.setLight(light);
        sensorData.setSound(sound);
        sensorData.setTimestamp(new Timestamp(System.currentTimeMillis()));

        return sensorDataRepository.save(sensorData);
    }

    @GetMapping(path="/all")
    public Iterable<SensorData> getAllEntries(@RequestParam String key, @RequestParam(defaultValue = "2") Integer limit) throws Exception {
        final String GET_KEY = env.getProperty("sensor-log.apiGetKey");

        if (!(key.equals(GET_KEY))) {
            throw new KeyNotValidException();
        }

        return sensorDataRepository.findAll(PageRequest.of(0, limit, Sort.by("timestamp").descending()));
    }

    @GetMapping(path="/{device}")
    public Iterable<SensorData> getEntriesByDevice(@PathVariable String device, @RequestParam String key, @RequestParam(defaultValue = "2") Integer limit) throws Exception {
        final String GET_KEY = env.getProperty("sensor-log.apiGetKey");

        if (!(key.equals(GET_KEY))) {
            throw new KeyNotValidException();
        }

        return sensorDataRepository.findByDevice(device, PageRequest.of(0, limit, Sort.by("timestamp").descending()));
    }
}
