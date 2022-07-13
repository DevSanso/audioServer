package com.github.DevSanso.audioControlServer.controller

import com.github.DevSanso.audioControlServer.model.FileMetaDataModel
import com.github.DevSanso.audioControlServer.services.DirectoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import javax.servlet.http.HttpServletResponse


@RestController
@RequestMapping("/directory")
class DirectoryController {
    @Autowired
    lateinit var directoryService: DirectoryService

    @PostMapping("/upload")
    fun upload(@RequestParam(name="file") file : MultipartFile,resp : HttpServletResponse) {
        val res = directoryService.uploadFile(file)
        res.onFailure {
            resp.status = 500
            resp.writer.println(it.message)
        }
        res.onSuccess {
            resp.status = 200
            resp.writer.print("ok")
        }
    }
    @DeleteMapping("/delete/:name")
    fun delete() {

    }
    @ResponseBody
    @GetMapping("/list")
    fun list() : List<FileMetaDataModel> = directoryService.fileMetaDataList()
}