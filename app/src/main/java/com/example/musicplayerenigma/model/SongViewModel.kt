package com.example.musicplayerenigma.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SongViewModel: ViewModel() {
    var songList = mutableListOf<Song>()
    var songLiveData = MutableLiveData<List<Song>>()

    init {
        songList.add(Song("Handmade", "Raisa","https://upload.wikimedia.org/wikipedia/id/a/a7/Raisa_handmade.jpeg"))
        songList.add(Song("Lelaku", "Fourtwnty","https://i1.sndcdn.com/artworks-000126261246-0ela5r-t500x500.jpg"))
        songList.add(Song("Sobat Ambyar", "Didi Kempot","https://www.makanabis.com/bima-content/2020/05/05/l-soundcloud49e2f7add622bcf33bda7d030d5d908c20200505121720-bimacms.jpg"))
        songLiveData.value = songList
    }

    fun addSong(newSong: Song){
        songList.add(newSong)
        songLiveData.value = songList
    }

    fun getSongs() = songLiveData as LiveData<List<Song>>
}