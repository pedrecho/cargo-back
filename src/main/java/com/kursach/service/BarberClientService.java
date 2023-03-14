package com.kursach.service;


import com.kursach.entity.BarberClient;
import com.kursach.entity.Book;
import com.kursach.repository.BarberClientRepository;
import com.kursach.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BarberClientService {
    @Autowired
    BarberClientRepository barberClientRepository;

    public HttpStatus Save(BarberClient barberClient) {
        barberClientRepository.save(barberClient);
        return HttpStatus.OK;
    }

    public HttpStatus Delete(Long barberClientId) {
        if (barberClientRepository.findById(barberClientId).isPresent()) {
            barberClientRepository.deleteById(barberClientId);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

}
