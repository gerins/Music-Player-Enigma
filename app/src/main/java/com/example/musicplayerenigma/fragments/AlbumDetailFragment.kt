package com.example.musicplayerenigma.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayerenigma.R
import com.example.musicplayerenigma.model.AlbumViewModel
import com.example.musicplayerenigma.recycleview.SongRecycleAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_album_detail.*

class AlbumDetailFragment : Fragment() {
    private val albumViewModel by activityViewModels<AlbumViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val albumId = arguments?.getInt("albumId") ?: 1

        albumViewModel.getAlbumWithId(albumId).observe(viewLifecycleOwner, Observer {
            artistNameSongDetail.text = it.artist
            albumNameSongDetail.text = it.albumTitle
            Picasso.with(activity).load(it.imgUrl).into(imageViewSongDetail)
        })

        songDetailRecycleView.layoutManager = LinearLayoutManager(activity)
        albumViewModel.getSongWithAlbumId(albumId).observe(viewLifecycleOwner, Observer {
            songDetailRecycleView.adapter = SongRecycleAdapter(it)
        })

        addSongActionButton.setOnClickListener {
            val bundle = bundleOf(Pair("albumId", albumId))
            Navigation.findNavController(it)
                .navigate(R.id.action_songDetailFragment_to_addSongFragment2, bundle)
        }
    }
}