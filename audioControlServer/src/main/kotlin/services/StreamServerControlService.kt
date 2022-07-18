package com.github.DevSanso.audioControlServer.services

import java.time.Duration


interface StreamServerControlService {
    fun play()
    fun stop()
    fun seek(duration: Duration)
    fun changeAlarm(fileName : String)
}