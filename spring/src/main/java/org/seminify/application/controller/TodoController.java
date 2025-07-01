package org.seminify.application.controller;

import java.util.List;

import org.seminify.application.dto.TodoDTO;
import org.seminify.application.entity.TodoEntity;
import org.seminify.application.service.TodoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("todo")
@RestController
@RequiredArgsConstructor
public class TodoController {
    private String userId = "temporary-user";
    private final TodoService todoService;

    @PostMapping
    public void post(@RequestBody TodoDTO todoDTO) {
        todoService.post(todoDTO.todoEntity().setUserId(userId));
    }

    @GetMapping
    public List<TodoEntity> get() {
        return todoService.get(userId);
    }

    @PatchMapping
    public void patch(@RequestBody TodoDTO todoDTO) {
        todoService.patch(todoDTO.todoEntity().setUserId(userId));
    }

    @DeleteMapping
    public void delete(@RequestBody TodoDTO todoDTO) {
        todoService.delete(todoDTO.todoEntity().setUserId(userId));
    }
}
