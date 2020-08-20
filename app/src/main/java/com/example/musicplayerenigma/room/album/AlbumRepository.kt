package com.example.musicplayerenigma.room.album

class AlbumRepository(private val albumDao: AlbumDao) {
    fun getAlbumWithSong() = albumDao.getAlbumWithSong()

    fun getAllAlbum() = albumDao.getAllAlbum()

    fun getAlbumWithId(id: Int) = albumDao.getAlbumWithId(id)

    fun createNewAlbum(album: Album) = albumDao.createNewAlbum(album)

    fun getSongWithAlbumId(id: Int) = albumDao.getSongWithAlbumId(id)

    fun insertNewSong(song: Song) = albumDao.insertNewSong(song)
}