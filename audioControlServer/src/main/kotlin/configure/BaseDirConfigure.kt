package com.github.DevSanso.audioControlServer.configure

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration
@ConfigurationProperties(prefix = "base")
class BaseDirConfigure {
    lateinit var dir : String
}