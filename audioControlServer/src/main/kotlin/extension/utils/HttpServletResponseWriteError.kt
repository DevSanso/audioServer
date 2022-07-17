package com.github.DevSanso.audioControlServer.extension.utils

import javax.servlet.http.HttpServletResponse

object HttpServletResponseWriteError {
    fun HttpServletResponse.writeError(status : Int, e : Exception) {
        this.status = status
        this.writer.print(e.toString())
    }
}