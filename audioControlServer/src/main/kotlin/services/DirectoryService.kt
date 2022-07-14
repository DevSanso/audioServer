package com.github.DevSanso.audioControlServer.services

import com.github.DevSanso.audioControlServer.model.DirectoryModel
import com.github.DevSanso.audioControlServer.repository.FileMetaRepository
import com.github.DevSanso.audioControlServer.extension.dtfp.MultipartFileToFileMetaEntity.toFileMetaEntity
import com.github.DevSanso.audioControlServer.extension.dtfp.FileMetaEntityToFileDataModel.toFileDataModel

import org.apache.commons.io.FilenameUtils


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import javax.transaction.Transactional


@Service
class DirectoryService @Autowired constructor(private val directoryModel: DirectoryModel,
                                              private val fileMetaRepository: FileMetaRepository){


    fun fileMetaDataList() =  fileMetaRepository.findAll().map {it.toFileDataModel()}


    @Transactional
    fun uploadFile(file : MultipartFile) {
        val entity = file.toFileMetaEntity()
        fileMetaRepository.save(entity)
        val res = directoryModel.upload(file)

        res.onFailure {
            throw IllegalArgumentException(it.message)
        }
    }
}