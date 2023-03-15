package com.kursach.service;


import com.kursach.entity.Performance;
import com.kursach.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PerformanceService {
    @Autowired
    PerformanceRepository performanceRepository;

    public HttpStatus Save(Performance performance) {
        performanceRepository.save(performance);
        return HttpStatus.OK;
    }

    public HttpStatus Delete(Long bookId) {
        if (performanceRepository.findById(bookId).isPresent()) {
            performanceRepository.deleteById(bookId);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
}
