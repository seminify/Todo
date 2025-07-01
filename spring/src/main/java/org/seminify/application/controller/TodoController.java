package org.seminify.application.controller;

import org.seminify.application.service.TodoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("todo")
@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
}
