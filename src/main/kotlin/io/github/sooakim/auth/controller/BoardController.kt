package io.github.sooakim.auth.controller

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/boards")
class BoardController{
    @GetMapping("/{id}")
    fun getBoard(model: Model, @PathVariable id: Long): String{
        model.addAttribute("title", "Board")
        return ""
    }
}