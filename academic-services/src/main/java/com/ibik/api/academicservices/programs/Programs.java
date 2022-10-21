package com.ibik.api.academicservices.programs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="programs") //ini nama table
public class Programs implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id //primary
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ini untyuk uniq data
    private int id;

    @Column(length = 20)
    @NotEmpty(message = "Name is required")
    private String name;

    private String description;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean is_active;

    public Programs() {
    }

    public Programs(int id, String name, String description, boolean is_active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.is_active = is_active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
}