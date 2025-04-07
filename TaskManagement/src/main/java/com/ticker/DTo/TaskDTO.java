package com.ticker.DTo;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class TaskDTO {
    @NotBlank(message = "Task name cannot be blank")
    private String name;
    @NotNull(message = "Due date cannot be null")
    private LocalDate dueDate;
    @NotBlank(message = "Priority cannot be blank")
    private String priority;
    @Pattern(regexp = "pending|completed", message = "Status must be 'pending' or 'completed'")
    private String status;

    // No 'id' field in the request DTO for creation

    public TaskDTO() {
    }

    public TaskDTO(String name, LocalDate dueDate, String priority, String status) {
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
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
