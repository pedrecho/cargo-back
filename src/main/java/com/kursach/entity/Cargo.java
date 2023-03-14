package com.kursach.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cargos")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String name;
    private String content;
    private String cityFrom;

    private String cityTo;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dataFrom;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate daraTo;

    public Cargo(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public LocalDate getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(LocalDate dataFrom) {
        this.dataFrom = dataFrom;
    }

    public LocalDate getDaraTo() {
        return daraTo;
    }

    public void setDaraTo(LocalDate daraTo) {
        this.daraTo = daraTo;
    }
}
