package dev.janette.sensorlog;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SensorDataRepository extends CrudRepository<SensorData, Integer> {
    List<SensorData> findAll(Pageable pageable);

    List<SensorData> findByDevice(String device, Pageable pageable);
}
