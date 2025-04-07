package com.ticker.Entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Task {
    private String id;
    private String name;
    private LocalDate dueDate;
    private String priority;
    private String status;

    public Task() {
        this.id = UUID.randomUUID().toString();
    }

    public Task(String name, LocalDate dueDate, String priority, String status) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
 }