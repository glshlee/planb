package com.glshlee.planb.controller

import com.glshlee.planb.service.TodoService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("todo")
class TodoController(
    val todoService: TodoService,
) {

//    @GetMapping
//    fun testTodo(): ResponseEntity<ResponseDTO<String>> {
//        val str = todoService.testService()
//        val response = ResponseDTO(listOf(str))
//        return ResponseEntity.ok().body(response)
//    }
}
