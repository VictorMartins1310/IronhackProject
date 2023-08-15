package com.bootcamp.project.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public interface TaskAPIController {
    String route = "tasks";
}