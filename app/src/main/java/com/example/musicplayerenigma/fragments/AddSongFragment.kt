package com.example.musicplayerenigma.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.musicplayerenigma.R
import com.example.musicplayerenigma.model.AlbumViewModel
import com.example.musicplayerenigma.room.album.Song
import kotlinx.android.synthetic.main.fragment_add_album.*
import kotlinx.android.synthetic.main.fragment_add_song.*

class AddSongFragment : Fragment() {
    private val albumViewModel by activityViewModels<AlbumViewModel>()

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

        val albumId = arguments?.getInt("albumId") ?: 1
        buttonSaveNewSong.setOnClickListener {
            val title = inputSongTitle.text.toString()
            val duration = inputSongDuration.text.toString()

            if (title == "" || duration == "") {
                return@setOnClickListener
            }

            albumViewModel.insertNewSong(
                Song(
                    songName = title,
                    songDuration = duration,
                    songAlbumId = albumId
                )
            )
            Navigation.findNavController(view).navigate(R.id.action_addSongFragment2_pop)
        }
    }
}