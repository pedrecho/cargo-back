package com.kursach.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String type;
    private String party;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate importation;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate exportation;
    private String driver;

    public Device() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public LocalDate getImportation() {
        return importation;
    }

    public void setImportation(LocalDate importation) {
        this.importation = importation;
    }

    public LocalDate getExportation() {
        return exportation;
    }

    public void setExportation(LocalDate exportation) {
        this.exportation = exportation;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
