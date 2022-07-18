package com.github.DevSanso.audioControlServer.controller

import com.github.DevSanso.audioControlServer.extension.utils.HttpServletResponseWriteError.writeError
import com.github.DevSanso.audioControlServer.services.StreamServerControlService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse


@RestController
@RequestMapping("/command")
class PlayerController {
    @Autowired
    lateinit var streamServerControlService: StreamServerControlService
    @PatchMapping("/play")
    fun playCommand(rasp : HttpServletResponse) {
        try {
            streamServerControlService.play()
        }catch(e : Exception) {
            rasp.writeError(500,e)
        }
        rasp.status = 200
    }
    @PatchMapping("/stop")
    fun stopCommand(rasp : HttpServletResponse) {
        try {
            streamServerControlService.stop()
        }catch(e : Exception) {
            rasp.writeError(500,e)
        }
        rasp.status = 200
    }
    @PatchMapping("/seek")
    fun seekCommand(@RequestBody rawDuration : String) {
    }
    @PutMapping("/setAlarm")
    fun setAlarmCommand(@RequestBody fileName : String,rasp : HttpServletResponse) {
        try {
            streamServerControlService.changeAlarm(fileName)
        }catch(e : Exception) {
            rasp.writeError(500,e)
        }
        rasp.status = 200
    }
}