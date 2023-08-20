package com.bootcamp.project.repos;

import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {
    List<TaskList> findTaskListsByUser(User user);
}
