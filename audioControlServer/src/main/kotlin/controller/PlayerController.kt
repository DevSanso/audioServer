package com.github.DevSanso.audioControlServer.controller

import com.github.DevSanso.audioControlServer.model.DirectoryModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class PlayerController {
    @Autowired
    lateinit var directoryModel: DirectoryModel
    @GetMapping("/play")
    fun playCommand() {

    }
    @GetMapping("/stop")
    fun stopCommand() {

    }
    @GetMapping("/previous")
    fun previousCommand() {

    }
    @GetMapping("/next")
    fun nextCommand() {

    }
}