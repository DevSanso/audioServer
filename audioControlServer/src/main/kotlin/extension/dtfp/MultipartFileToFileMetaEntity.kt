package com.github.DevSanso.audioControlServer.extension.dtfp

import com.github.DevSanso.audioControlServer.entity.FileMetaEntity
import com.github.DevSanso.audioControlServer.model.parts.ImageMetaData

import org.apache.tika.metadata.Metadata
import org.apache.tika.parser.ParseContext
import org.apache.tika.parser.mp3.Mp3Parser
import org.jaudiotagger.audio.mp3.MP3File
import org.springframework.web.multipart.MultipartFile
import org.xml.sax.helpers.DefaultHandler
import java.io.File
import java.io.InputStream


object MultipartFileToFileMetaEntity {

    private fun createTmpFile() = File.createTempFile("mp3_",".tmp")
    private fun copyData(dst : File,stream : InputStream) = dst.writeBytes(stream.readBytes())
    private fun getImageData(mp3File : MP3File) : ImageMetaData{
        val artwork = mp3File.tag.firstArtwork
        return ImageMetaData(
            contentType = artwork.mimeType,
            data = artwork.binaryData
        )
    }

    fun MultipartFile.toFileMetaEntity() : FileMetaEntity {
        val tmp = createTmpFile()

        val fileName = this.name

        val handler = DefaultHandler()
        val metadata = Metadata()
        val parser = Mp3Parser()
        val parseCtx = ParseContext()
        val tmpStream = tmp.inputStream()
        val multipartStream = this.inputStream
        try {
            copyData(tmp,multipartStream)
            parser.parse(tmpStream,handler,metadata,parseCtx)
        }finally {
            multipartStream.close()
            tmpStream.close()
        }
        val image = getImageData(MP3File())

        return FileMetaEntity(
            title = metadata["xmpDM:album"],
            fileName = fileName,
            artist = metadata["xmpDM:artist"],
            imageType = image.contentType,
            imageData = image.data

        )
    }
}