package com.kursach.service;

import com.kursach.entity.Autoblog;
import com.kursach.repository.AutoblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AutoblogService {
    @Autowired
    AutoblogRepository autoblogRepository;

    public HttpStatus Create(Autoblog autoblog){
        if (autoblog.getId() == null) {
            autoblog.setPublishedAt(LocalDateTime.now());
            autoblogRepository.save(autoblog);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

    public HttpStatus Update(Autoblog autoblog){
        if (autoblog.getId() != null && autoblogRepository.findById(autoblog.getId()).isPresent()) {
            autoblogRepository.save(autoblog);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

    public HttpStatus Delete(Long autoblogId){
        if (autoblogRepository.findById(autoblogId).isPresent()){
            autoblogRepository.deleteById(autoblogId);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

}
