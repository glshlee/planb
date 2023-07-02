package com.glshlee.planb.dto

import com.glshlee.planb.model.Todo

class TodoDTO(
    val id: String?,
    val title: String?,
    val done: Boolean?,
) {

    constructor(entity: Todo) : this(
        id = entity.id,
        title = entity.title,
        done = entity.done,
    )

    companion object {
        fun toEntity(dto: TodoDTO): Todo {
            return Todo(id = dto.id, userId = "temporary-user", title = dto.title ?: "test", done = dto.done ?: false)
        }
    }
}
