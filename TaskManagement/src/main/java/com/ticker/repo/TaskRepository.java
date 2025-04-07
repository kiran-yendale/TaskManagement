package com.ticker.repo;

import org.springframework.stereotype.Repository;

import com.ticker.Entity.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
public class TaskRepository {
    private final Map<String, Task> tasks = new HashMap<>();

    public List<Task> findAll(String sortBy) {
        List<Task> allTasks = new ArrayList<>(tasks.values());
        if ("dueDate".equalsIgnoreCase(sortBy)) {
            allTasks.sort((t1, t2) -> t1.getDueDate().compareTo(t2.getDueDate()));
        } else if ("priority".equalsIgnoreCase(sortBy)) {
            allTasks.sort((t1, t2) -> t1.getPriority().compareTo(t2.getPriority()));
        }
        return allTasks;
    }

    public Optional<Task> findById(String id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public Task save(Task task) {
        tasks.put(task.getId(), task);
        return task;
    }

    public void deleteById(String id) {
        tasks.remove(id);
    }
}