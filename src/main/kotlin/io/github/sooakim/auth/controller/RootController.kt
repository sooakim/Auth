package io.github.sooakim.auth.controller

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RootController{
    @GetMapping("/")
    fun getRoot(model: Model): String{
        model.addAttribute("title", "Root")
        return "index"
    }
}