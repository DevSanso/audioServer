package com.github.DevSanso.audioControlServer.configure

import okhttp3.OkHttpClient
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
@ConfigurationProperties(prefix = "stream")
class StreamClientConfigure {
    lateinit var address : String
}


@Configuration
class StreamClientBeanConfigure {
    @Bean("steamClientBean")
    fun client() : OkHttpClient = OkHttpClient()
}