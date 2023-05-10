package com.glshlee.planb.service

import com.glshlee.planb.config.HLogger
import com.glshlee.planb.model.Todo
import com.glshlee.planb.persistence.TodoRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class TodoService(
    val todoRepository: TodoRepository,
) {
    companion object : HLogger()

    fun create(entity: Todo): List<Todo> {
        // validations
        validate(entity)

        todoRepository.save(entity)
        logger.info("Entity Id ${entity.id} is saved.")

        return todoRepository.findByUserId(entity.userId)
    }

    private fun validate(entity: Todo) {
        if (entity == null) {
            logger.warn("Entity cannot be null.")
            throw RuntimeException("Entity cannot be null.")
        }

        if (entity.userId == null) {
            logger.warn("Unknown user.")
            throw RuntimeException("Unknown user.")
        }
    }
}
