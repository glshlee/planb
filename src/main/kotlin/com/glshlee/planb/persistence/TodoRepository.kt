package com.glshlee.planb.persistence

import com.glshlee.planb.model.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo, String> {

    fun findByUserId(userId: String): List<Todo>
}
