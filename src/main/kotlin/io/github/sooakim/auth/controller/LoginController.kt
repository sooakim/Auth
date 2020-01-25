package io.github.sooakim.auth.controller

import io.github.sooakim.auth.data.repository.UserRepository
import io.github.sooakim.auth.util.ext.encodeSHA256
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpSession

@RestController
@RequestMapping("/login")
class LoginController{
    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping
    fun getLogin(model: Model): String{
        model.addAttribute("title", "Login")
        return "login"
    }

    @PostMapping
    fun postLogin(
            model: Model,
            session: HttpSession,
            @RequestParam("id")
            userId: String,
            @RequestParam("password")
            password: String
    ): String {
        return try {
            val user = userRepository.findByUserId(userId)
            if(user.password == password.encodeSHA256()) {
                session.setAttribute("userId", user.userId)
                model.addAttribute("title", "Welcome")
                model.addAttribute("userId", "userId")
                "welcome"
            }
            else {
                model.addAttribute("title", "Login")
                "login"
            }
        } catch (e: Exception) {
            e.printStackTrace()

            model.addAttribute("title", "Sign")
            "sign"
        }
    }
}