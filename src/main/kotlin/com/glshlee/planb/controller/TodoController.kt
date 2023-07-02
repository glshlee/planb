package com.glshlee.planb.controller

import com.glshlee.planb.dto.ResponseDTO
import com.glshlee.planb.dto.TodoDTO
import com.glshlee.planb.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("todo")
class TodoController(
    val todoService: TodoService,
) {

    @PostMapping
    fun createTodo(@RequestBody dto: TodoDTO): ResponseEntity<ResponseDTO<TodoDTO>> {
        runCatching {
            val entity = TodoDTO.toEntity(dto)
            val entities = todoService.create(entity)
            val dtos = entities.map { TodoDTO(it) }
            val response = ResponseDTO(dtos)
            return ResponseEntity.ok().body(response)
        }.also {
            return ResponseEntity.badRequest().body(null)
        }
    }

    @GetMapping
    fun retrieveTodoList(): ResponseEntity<ResponseDTO<TodoDTO>> {
        val temporaryUserId = "temporary-user" // temporary user id.
        val entities = todoService.retrieve(temporaryUserId)
        val dtos = entities.map { TodoDTO(it) }
        val response = ResponseDTO(dtos)

        return ResponseEntity.ok().body(response)
    }

    @PutMapping
    fun updateTodo(@RequestBody dto: TodoDTO): ResponseEntity<ResponseDTO<TodoDTO>> {
        val entity = TodoDTO.toEntity(dto)
        val entities = todoService.update(entity)
        val dtos = entities.map { TodoDTO(it) }
        val response = ResponseDTO(dtos)

        return ResponseEntity.ok().body(response)
    }

    @DeleteMapping
    fun deleteTodo(@RequestBody dto: TodoDTO): ResponseEntity<ResponseDTO<TodoDTO>> {
        runCatching {
            val entity = TodoDTO.toEntity(dto)
            val entities = todoService.delete(entity)
            val dtos = entities.map { TodoDTO(it) }
            val response = ResponseDTO(dtos)

            return ResponseEntity.ok().body(response)
        }.also {
            return ResponseEntity.badRequest().body(null)
        }
    }
}
