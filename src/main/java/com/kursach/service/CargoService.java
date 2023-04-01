package com.kursach.service;

import com.kursach.entity.Cargo;
import com.kursach.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CargoService {
    @Autowired
    CargoRepository cargoRepository;

    public HttpStatus Save(Cargo cargo){
        cargoRepository.save(cargo);
        return HttpStatus.OK;
    }

    public HttpStatus Delete(Long cargoId){
        if (cargoRepository.findById(cargoId).isPresent()){
            cargoRepository.deleteById(cargoId);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

}
