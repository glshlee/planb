package com.glshlee.planb.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator

@Entity
class Todo(
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    val id: String? = null,
    val userId: String,
    val title: String,
    val done: Boolean,
) {
    constructor(userId: String, title: String, done: Boolean) : this(null, userId, title, done)
}
