package com.glshlee.planb.service

import com.glshlee.planb.model.Todo
import com.glshlee.planb.persistence.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoService(
    val todoRepository: TodoRepository
) {
    fun testService(): String {
        val entity = Todo("test", "My first todo item", false)
        todoRepository.save(entity)
        val savedEntity = todoRepository.findById(entity.id!!).get()
        return savedEntity.title
    }
}
