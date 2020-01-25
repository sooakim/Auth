package io.github.sooakim.auth.data.repository

import io.github.sooakim.auth.data.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User, Long>{
    fun findByUserId(userId: String): User
}