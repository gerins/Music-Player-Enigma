package com.example.musicplayerenigma.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.musicplayerenigma.R
import com.example.musicplayerenigma.model.Song
import com.example.musicplayerenigma.model.SongViewModel
import kotlinx.android.synthetic.main.fragment_add_song.*
import kotlinx.android.synthetic.main.fragment_song_list.*

class AddSongFragment : Fragment() {
    private val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSubmitNewSong.setOnClickListener {
            val title = inputAlbumName.text.toString()
            val artist = inputArtistName.text.toString()
            val imageUrl = inputImageUrl.text.toString()

            if (title == "" || artist == "" || imageUrl == "" ){
                return@setOnClickListener
            }

            val newSong = Song(title, artist, imageUrl)
            songViewModel.addSong(newSong)

            Navigation.findNavController(view).navigate(R.id.action_addSongFragment_pop)
        }
    }
}