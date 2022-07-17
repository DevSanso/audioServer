package com.github.DevSanso.audioControlServer.repository

import com.github.DevSanso.audioControlServer.entity.FileMetaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface FileMetaRepository : JpaRepository<FileMetaEntity,String>{
    @Query("SELECT * FROM file_meta ORDER BY CHAR_LENGTH(title) ASC", nativeQuery = true)
    fun findAllAndSortedTitle() : List<FileMetaEntity>
}