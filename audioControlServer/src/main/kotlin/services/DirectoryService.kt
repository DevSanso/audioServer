package com.github.DevSanso.audioControlServer.services

import com.github.DevSanso.audioControlServer.model.DirectoryModel
import com.github.DevSanso.audioControlServer.repository.FileMetaRepository
import com.github.DevSanso.audioControlServer.extension.dtfp.MultipartFileToFileMetaEntity.toFileMetaEntity
import com.github.DevSanso.audioControlServer.extension.dtfp.FileMetaEntityToFileDataModel.toFileDataModel
import com.github.DevSanso.audioControlServer.model.FileMetaDataModel

import org.apache.commons.io.FilenameUtils


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import javax.transaction.Transactional


@Service
class DirectoryService @Autowired constructor(private val directoryModel: DirectoryModel,
                                              private val fileMetaRepository: FileMetaRepository){


    fun fileMetaDataList() =  fileMetaRepository.findAllAndSortedTitle().map {it.toFileDataModel()}


    @Transactional
    fun uploadFile(file : MultipartFile) {
        val entity = file.toFileMetaEntity()
        fileMetaRepository.save(entity)
        directoryModel.upload(file)
    }
    @Transactional
    fun deleteFile(fileName : String) {
        fileMetaRepository.deleteAllById(listOf(fileName))
        directoryModel.delete(fileName)
    }

}