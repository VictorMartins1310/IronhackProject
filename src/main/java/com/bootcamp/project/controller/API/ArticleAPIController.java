package com.bootcamp.project.controller.API;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "todoListAPI", value = "api")
public interface ArticleAPIController {
    String route = "articles";
}
