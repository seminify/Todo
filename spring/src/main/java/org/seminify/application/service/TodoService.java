package org.seminify.application.service;

import java.util.List;

import org.seminify.application.entity.TodoEntity;
import org.seminify.application.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class TodoService {
    private final TodoRepository todoRepository;

    private void runtimeException(String message) {
        log.warn(message);
        throw new RuntimeException(message);
    }

    private void isNull(TodoEntity todoEntity) {
        if (todoEntity == null) {
            runtimeException("Entity cannot be null");
        }
        if (todoEntity.getUserId() == null) {
            runtimeException("Unknown user");
        }
    }

    public void post(TodoEntity todoEntity) {
        isNull(todoEntity);
        todoRepository.save(todoEntity);
        log.info("Entity {} is saved", todoEntity);
    }

    public List<TodoEntity> get(String userId) {
        return todoRepository.findByUserId(userId);
    }

    public void patch(TodoEntity todoEntity) {
        isNull(todoEntity);
        todoRepository.findById(todoEntity.getId()).orElseThrow().setTitle(todoEntity.getTitle())
                .setDone(todoEntity.getDone());
    }

    public void delete(TodoEntity todoEntity) {
        isNull(todoEntity);
        todoRepository.deleteById(todoEntity.getId());
    }
}
