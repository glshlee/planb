package com.glshlee.planb.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("todo")
class TodoController {

    @GetMapping
    fun testTodo(): ResponseEntity<String> {
        return ResponseEntity.ok().body("Test TODO")
    }
}
