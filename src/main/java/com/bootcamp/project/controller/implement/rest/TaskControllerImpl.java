package com.bootcamp.project.controller.implement.rest;

import com.bootcamp.project.controller.abstracts.TaskController;
import com.bootcamp.project.dto.TaskDTO;
import com.bootcamp.project.dto.TaskListTasksDTO;
import com.bootcamp.project.mappers.TaskMapper;
import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.model.Task;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** This Controller is destined for Tasks
* It can Create and Update a Task
* A delete function here is not needed,it can only be deleted by deleting the Task List
*/
@RestController
@RequestMapping(name = "tasklist", value = "todolist/tasklist/{taskLID}")
public class TaskControllerImpl extends TaskController {
    public TaskControllerImpl(TaskListService taskListService, TaskService taskService, TaskMapper taskMapper, TodoListMapper taskListMapper) {
        super(taskListService, taskService, taskMapper, taskListMapper);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<TaskDTO> addTask(@PathVariable("taskLID") Long taskID, @RequestBody TaskDTO taskDTO){
        Task task = taskMapper.toEntity(taskDTO);
        TaskList taskList = taskListService.addTask2List(taskID, task);
        return taskMapper.toDto(taskService.getAllTasksOfTaskList(taskList));
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TaskListTasksDTO getAllTasksOfTaskList(@PathVariable("taskLID") Long taskID){
        return taskListMapper.toTaskListTasksDTO(taskListService.getTaskListByID(taskID));
    }
    @Override
    @PatchMapping(value = "/task/{taskID}/done")
    @ResponseStatus(HttpStatus.OK)
    public void taskDone(@PathVariable("taskID") Long idTask) {
        taskService.taskDone(idTask);
    }
    @PatchMapping(value ="/task/{taskID}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO updateTask(@PathVariable("taskID") Long idTask, @RequestParam("tname") String taskName){
        return taskMapper.toDto(taskService.updateTaskName(idTask, taskName));
    }
}