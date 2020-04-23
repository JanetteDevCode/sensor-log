package dev.janette.sensorlog.controller;

import dev.janette.sensorlog.SensorData;
import dev.janette.sensorlog.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path="/log")
public class LogViewerController {
    @Autowired
    private SensorDataRepository sensorDataRepository;

    @GetMapping(path="/all")
    public String getAllEntries(@RequestParam(defaultValue = "2") Integer limit, Model model) {
        List<SensorData> sensorDataList = sensorDataRepository.findAll(PageRequest.of(0, limit, Sort.by("timestamp").descending()));
        model.addAttribute("sensorDataList", sensorDataList);
        return "log";
    }

    @GetMapping(path="/{device}")
    public String getEntriesByDevice(@PathVariable String device, @RequestParam(defaultValue = "2") Integer limit, Model model) {
        List<SensorData> sensorDataList = sensorDataRepository.findByDevice(device, PageRequest.of(0, limit, Sort.by("timestamp").descending()));
        model.addAttribute("sensorDataList", sensorDataList);
        return "log";
    }
}
