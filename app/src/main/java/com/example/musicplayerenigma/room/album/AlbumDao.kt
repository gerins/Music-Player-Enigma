package com.example.musicplayerenigma.room.album

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface AlbumDao {
    @Transaction
    @Query("SELECT * FROM Album")
    fun getAlbumWithSong(): LiveData<List<AlbumWithSong>>

    @Query("SELECT * FROM Album")
    fun getAllAlbum(): LiveData<List<Album>>

    @Query(value = "SELECT * FROM Album WHERE albumId = :id")
    fun getAlbumWithId(id:Int): LiveData<Album>

    @Insert
    fun createNewAlbum(album: Album)

    @Query(value = "SELECT * FROM Song WHERE songAlbumId = :id")
    fun getSongWithAlbumId(id:Int): LiveData<List<Song>>

    @Insert
    fun insertNewSong(song: Song)
}