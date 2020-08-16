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
import com.example.musicplayerenigma.model.SongViewModel
import com.example.musicplayerenigma.recycleview.SongRecycleAdapter
import kotlinx.android.synthetic.main.fragment_song_list.*

class SongListFragment : Fragment() {
    private val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_song_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        songListRecycleView.layoutManager = LinearLayoutManager(activity)
        songViewModel.getSongs().observe(viewLifecycleOwner, Observer {
            songListRecycleView.adapter = SongRecycleAdapter(it, activity)
        })

        addSongActionButton.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_songListFragment_to_addSongFragment)
        }
    }
}