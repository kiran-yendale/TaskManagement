package com.ticker.serviceIMPl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticker.DTo.TaskDTO;
import com.ticker.Entity.Task;
import com.ticker.repo.TaskRepository;
import com.ticker.service.TaskService;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks(String sortBy) {
        return taskRepository.findAll(sortBy);
    }

    @Override
    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task createTask(TaskDTO taskDTO) {
        // Validation can be added here
        Task task = new Task(taskDTO.getName(), taskDTO.getDueDate(), taskDTO.getPriority(), taskDTO.getStatus());
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> updateTask(String id, TaskDTO taskDTO) {
        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            if (taskDTO.getName() != null) {
                existingTask.setName(taskDTO.getName());
            }
            if (taskDTO.getDueDate() != null) {
                existingTask.setDueDate(taskDTO.getDueDate());
            }
            if (taskDTO.getPriority() != null) {
                existingTask.setPriority(taskDTO.getPriority());
            }
            if (taskDTO.getStatus() != null) {
                existingTask.setStatus(taskDTO.getStatus());
            }
            return Optional.of(taskRepository.save(existingTask));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteTask(String id) {
        if (taskRepository.findById(id).isPresent()) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Task> markTaskComplete(String id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setStatus("completed");
            return Optional.of(taskRepository.save(task));
        }
        return Optional.empty();
    }
}