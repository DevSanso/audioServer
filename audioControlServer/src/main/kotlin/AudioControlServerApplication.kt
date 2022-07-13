package com.github.DevSanso.audioControlServer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AudioControlServerApplication

fun main(args: Array<String>) {
	runApplication<AudioControlServerApplication>(*args)
}
