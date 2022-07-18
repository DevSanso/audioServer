package com.github.DevSanso.audioControlServer.services


import com.github.DevSanso.audioControlServer.model.FileMetaDataModel
import org.springframework.web.multipart.MultipartFile
import javax.transaction.Transactional

interface DirectoryService{
    fun fileMetaDataList() : List<FileMetaDataModel>
    @Transactional
    fun uploadFile(file : MultipartFile)
    @Transactional
    fun deleteFile(fileName : String)

}