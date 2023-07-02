package com.glshlee.planb.service

import com.glshlee.planb.config.HLogger
import com.glshlee.planb.model.Todo
import com.glshlee.planb.persistence.TodoRepository
import org.springframework.data.repository.findByIdOrNull
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

    fun retrieve(userId: String): List<Todo> {
        return todoRepository.findByUserId(userId)
    }

    fun update(entity: Todo): List<Todo> {
        entity.id?.let { id ->
            todoRepository.findByIdOrNull(id)
        }?.let { todo ->
            todo.title = entity.title
            todo.done = entity.done

            todoRepository.save(todo)
        }

        return retrieve(entity.userId)
    }

    fun delete(entity: Todo): List<Todo> {
        runCatching {
            todoRepository.delete(entity)
        }.onFailure {
            // TODO: log 출력
            throw RuntimeException("error deleting entity ${entity.id}")
        }

        return retrieve(entity.userId)
    }
}
