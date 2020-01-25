package io.github.sooakim.auth.controller

import io.github.sooakim.auth.data.entity.User
import io.github.sooakim.auth.data.repository.UserRepository
import io.github.sooakim.auth.util.ext.encodeSHA256
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sign")
class SignController{
    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping
    fun getSign(model: Model): String{
        model.addAttribute("title", "Sign")
        return "sign"
    }

    @PostMapping
    fun postSign(
            model: Model,
            @RequestParam("id")
            userId: String,
            @RequestParam("password")
            password: String
    ): String{
        val newUser = User(userId = userId, password = password.encodeSHA256())
        return try{
            val user = userRepository.save(newUser)
            println(user.toString())

            model.addAttribute("title", "Login")
            "login"
        } catch(e: Exception){
            e.printStackTrace()

            model.addAttribute("title", "Sign")
            "sign"
        }
    }
}