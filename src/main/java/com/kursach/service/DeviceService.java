package com.kursach.service;


import com.kursach.entity.Device;
import com.kursach.entity.Movie;
import com.kursach.repository.DeviceRepository;
import com.kursach.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    @Autowired
    DeviceRepository deviceRepository;

    public HttpStatus Save(Device device) {
        deviceRepository.save(device);
        return HttpStatus.OK;
    }

    public HttpStatus Delete(Long bookId) {
        if (deviceRepository.findById(bookId).isPresent()) {
            deviceRepository.deleteById(bookId);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
}
