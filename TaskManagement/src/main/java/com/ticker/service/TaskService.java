package com.ticker.service;
			
import java.util.List;
import java.util.Optional;

import com.ticker.DTo.TaskDTO;
import com.ticker.Entity.Task;

public interface TaskService {
    List<Task> getAllTasks(String sortBy);
    Optional<Task> getTaskById(String id);
    Task createTask(TaskDTO taskDTO);
    Optional<Task> updateTask(String id, TaskDTO taskDTO);
    boolean deleteTask(String id);
    Optional<Task> markTaskComplete(String id);
}