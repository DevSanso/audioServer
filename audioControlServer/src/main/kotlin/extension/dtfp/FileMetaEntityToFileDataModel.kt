package com.github.DevSanso.audioControlServer.extension.dtfp

import com.github.DevSanso.audioControlServer.entity.FileMetaEntity
import com.github.DevSanso.audioControlServer.model.FileMetaDataModel
import com.github.DevSanso.audioControlServer.model.parts.ImageMetaData


object FileMetaEntityToFileDataModel {
    fun FileMetaEntity.toFileDataModel() : FileMetaDataModel = FileMetaDataModel(
        this.title,
        this.artist,
        ImageMetaData(this.imageType,this.imageData))
}