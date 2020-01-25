package io.github.sooakim.auth.data.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class User(
        @Id
        @GeneratedValue
        val _id: Long? = null,
        val userId: String,
        val password: String
)