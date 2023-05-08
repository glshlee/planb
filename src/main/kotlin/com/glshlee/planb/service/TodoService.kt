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
    fun testService(): String {
        val entity = Todo("test", "My first todo item", false)
        logger.info("")
        todoRepository.save(entity)
        val savedEntity = todoRepository.findById(entity.id!!).get()
        return savedEntity.title
    }
}
