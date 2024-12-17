package com.example.demo.model;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "connections")
public class Connections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conn_id")
    private Long connId;

    @Column(name = "conn_name", nullable = false)
    private String connName;

    @Column(name = "conn_desc", nullable = false)
    private String connDesc;

    @Column(name = "conn_date", nullable = false)
    private LocalDate connDate;

    @Column(name = "conn_type", nullable = false)
    private String connType;

    // Default constructor
    public Connections() {
    }

    // Constructor with parameters
    public Connections(String connName, String connDesc, LocalDate connDate, String connType) {
        this.connName = connName;
        this.connDesc = connDesc;
        this.connDate = connDate;
        this.connType = connType;
    }

    // Getters and Setters
    public Long getConnId() {
        return connId;
    }

    public void setConnId(Long connId) {
        this.connId = connId;
    }

    public String getConnName() {
        return connName;
    }

    public void setConnName(String connName) {
        this.connName = connName;
    }

    public String getConnDesc() {
        return connDesc;
    }

    public void setConnDesc(String connDesc) {
        this.connDesc = connDesc;
    }

    public LocalDate getConnDate() {
        return connDate;
    }

    public void setConnDate(LocalDate connDate) {
        this.connDate = connDate;
    }

    public String getConnType() {
        return connType;
    }

    public void setConnType(String connType) {
        this.connType = connType;
    }

    @Override
    public String toString() {
        return "Connections{" +
                "connId=" + connId +
                ", connName='" + connName + '\'' +
                ", connDesc='" + connDesc + '\'' +
                ", connDate=" + connDate +
                ", connType='" + connType + '\'' +
                '}';
    }
}
