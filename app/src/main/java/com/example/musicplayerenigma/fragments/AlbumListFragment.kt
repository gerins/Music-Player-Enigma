package com.example.musicplayerenigma.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayerenigma.R
import com.example.musicplayerenigma.model.AlbumViewModel
import com.example.musicplayerenigma.recycleview.AlbumRecycleAdapter
import kotlinx.android.synthetic.main.fragment_album_list.*

class AlbumListFragment : Fragment() {
    private val songViewModel by activityViewModels<AlbumViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        songListRecycleView.layoutManager = LinearLayoutManager(activity)
        songViewModel.getAllAlbum().observe(viewLifecycleOwner, Observer {
            songListRecycleView.adapter = AlbumRecycleAdapter(it, activity)
        })

        addAlbumActionButton.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_songListFragment_to_addSongFragment)
        }
    }
}