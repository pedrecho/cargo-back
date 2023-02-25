package com.kursach.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String type;
    private String party;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date importation;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date exportation;
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

    public Date getImportation() {
        return importation;
    }

    public void setImportation(Date importation) {
        this.importation = importation;
    }

    public Date getExportation() {
        return exportation;
    }

    public void setExportation(Date exportation) {
        this.exportation = exportation;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
