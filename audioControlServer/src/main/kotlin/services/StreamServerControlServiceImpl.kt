package com.github.DevSanso.audioControlServer.services

import com.github.DevSanso.audioControlServer.configure.StreamClientConfigure
import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Duration
import javax.annotation.Resource


@Service("streamServerControlService")
class StreamServerControlServiceImpl : StreamServerControlService {
    @Resource(name = "streamClientBean")
    lateinit var client : OkHttpClient
    @Autowired
    lateinit var configure: StreamClientConfigure

    override fun play() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override fun seek(duration: Duration) {
        TODO("Not yet implemented")
    }

    override fun changeAlarm(fileName: String) {
        TODO("Not yet implemented")
    }
}