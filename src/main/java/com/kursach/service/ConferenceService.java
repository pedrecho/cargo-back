package com.kursach.service;

import com.kursach.entity.Cargo;
import com.kursach.entity.Conference;
import com.kursach.repository.CargoRepository;
import com.kursach.repository.ConferenceRepository;
import com.kursach.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ConferenceService {
    @Autowired
    ConferenceRepository conferenceRepository;

    public HttpStatus Save(Conference conference){
        conferenceRepository.save(conference);
        return HttpStatus.OK;
    }

    public HttpStatus Delete(Long conferenceId){
        if (conferenceRepository.findById(conferenceId).isPresent()){
            conferenceRepository.deleteById(conferenceId);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

}
