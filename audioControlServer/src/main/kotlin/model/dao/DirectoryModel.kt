package com.github.DevSanso.audioControlServer.model.dao

import com.github.DevSanso.audioControlServer.configure.BaseDirConfigure
import org.apache.commons.io.FilenameUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.io.FileOutputStream
import java.nio.file.Path
import kotlin.io.path.Path


@Component
@Scope("singleton")

class DirectoryModel @Autowired constructor(baseDirConfigure: BaseDirConfigure)
{
    private val basePath = baseDirConfigure.dir

    private fun createOutputStream(p : Path) :FileOutputStream {
        val f = File(p.toString())
        if(!f.createNewFile()) throw IllegalArgumentException("already exist file")

        return FileOutputStream(f)

    }
    fun upload(file : MultipartFile) {
        val ext = FilenameUtils.getExtension(file.name)
        if (ext != ".mp3") throw IllegalArgumentException( "$ext != .mp3")


        val hhdPath = Path(basePath,file.name)
        val wStream = createOutputStream(hhdPath)
        wStream.write(file.bytes)
        wStream.close()
    }
    fun delete(fileName : String) {
        val phyFilePath = Path(basePath,fileName)
        val deleted = Files.deleteIfExists(phyFilePath)
        if(deleted) throw NotFoundException()
    }
}