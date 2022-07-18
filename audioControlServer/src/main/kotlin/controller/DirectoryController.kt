package com.github.DevSanso.audioControlServer.controller

import com.github.DevSanso.audioControlServer.model.vo.FileMetaDataModel
import com.github.DevSanso.audioControlServer.services.DirectoryService
import com.github.DevSanso.audioControlServer.extension.utils.HttpServletResponseWriteError.writeError
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
        try {
            directoryService.uploadFile(file)
        }catch(e : Exception) {
            resp.writeError(500,e)
            return
        }
        resp.status = 200
        resp.writer.print("ok")
    }
    @DeleteMapping("/delete/{fileName}")
    fun delete(@PathVariable("fileName") name : String,resp : HttpServletResponse) {
        try {
            directoryService.deleteFile(name)
        }catch (e : Exception) {
            resp.writeError(500,e)
            return
        }
        resp.status = 200
        resp.writer.print("deleted")
    }
    @ResponseBody
    @GetMapping("/list")
    fun list() : List<FileMetaDataModel> = directoryService.fileMetaDataList()
}