package com.github.DevSanso.audioControlServer.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table




@Entity
@Table(name="file_meta")
class FileMetaEntity(title : String,
                     fileName : String,
                     artist : String,
                     imageType : String,
                     imageData : ByteArray) {
    @Id
    @Column(name="file_name", nullable = false)
    var fileName : String = fileName

    @Column(name="title")
    var title : String = title



    @Column(name="artist")
    var artist : String = artist
    @Column(name="image_type")
    var imageType : String = imageType
    @Column(name="image_data",columnDefinition = "LONGBLOB")
    var imageData : ByteArray = imageData

}