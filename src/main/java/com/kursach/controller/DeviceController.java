package com.kursach.controller;


import com.kursach.entity.Device;
import com.kursach.repository.DeviceRepository;
import com.kursach.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    private final DeviceRepository device;

    DeviceController(DeviceRepository device) {
        this.device = device;
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Optional<Device> GetById(@PathVariable(name = "id") Long id) {
        return this.device.findById(id);
    }

    @PostMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatus Delete(@PathVariable(name = "id") Long id) {
        return deviceService.Delete(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public List<Device> GetAll() {
        return this.device.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatus Save(Device device) {
        return deviceService.Save(device);
    }
}