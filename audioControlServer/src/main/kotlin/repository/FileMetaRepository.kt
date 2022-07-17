package com.github.DevSanso.audioControlServer.repository

import com.github.DevSanso.audioControlServer.entity.FileMetaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface FileMetaRepository : JpaRepository<FileMetaEntity,String>{

}