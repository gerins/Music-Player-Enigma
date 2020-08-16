package com.example.musicplayerenigma.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.musicplayerenigma.R
import com.example.musicplayerenigma.model.SongViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_song_detail.*

class SongDetailFragment : Fragment() {
    private val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_song_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = arguments?.getInt("position") ?: 0
        songViewModel.getSongs().observe(viewLifecycleOwner, Observer {
            artistNameSongDetail.text = it[position].artist
            albumNameSongDetail.text = it[position].title
            Picasso.with(activity).load(it[position].imgUrl).into(imageViewSongDetail)
        })
    }
}