package org.aeh.lab13.repository;

import org.aeh.lab13.model.Task;
import org.aeh.lab13.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}

