package com.glshlee.planb.service

import com.glshlee.planb.config.HLogger
import com.glshlee.planb.model.Todo
import com.glshlee.planb.persistence.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoService(
    val todoRepository: TodoRepository,
) {
    companion object : HLogger()

    fun create(entity: Todo): List<Todo> {
        todoRepository.save(entity)
        logger.info("Entity Id ${entity.id} is saved.")

        return todoRepository.findByUserId(entity.userId)
    }
}
