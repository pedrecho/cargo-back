package com.kursach.service;


import com.kursach.entity.Car;
import com.kursach.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public HttpStatus Save(Car car) {
        carRepository.save(car);
        return HttpStatus.OK;
    }

    public HttpStatus Delete(Long bookId) {
        if (carRepository.findById(bookId).isPresent()) {
            carRepository.deleteById(bookId);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
}
