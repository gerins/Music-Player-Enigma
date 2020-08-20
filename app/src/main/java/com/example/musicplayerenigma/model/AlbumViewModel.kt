package com.example.musicplayerenigma.model

import android.app.Application
import androidx.lifecycle.*
import com.example.musicplayerenigma.room.AppRoomDatabase
import com.example.musicplayerenigma.room.album.Album
import com.example.musicplayerenigma.room.album.AlbumRepository
import com.example.musicplayerenigma.room.album.Song
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumViewModel(application: Application) : AndroidViewModel(application) {
    private val repository =
        AlbumRepository(AppRoomDatabase.getDatabaseInstance(application).albumDao())

    fun getAlbumWithSong() = repository.getAlbumWithSong()

    fun getAllAlbum() = repository.getAllAlbum()

    fun getAlbumWithId(id: Int) = repository.getAlbumWithId(id)

    fun createNewAlbum(album: Album) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createNewAlbum(album)
        }
    }

    fun getSongWithAlbumId(id: Int) = repository.getSongWithAlbumId(id)

    fun insertNewSong(song: Song) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNewSong(song)
        }
    }
}