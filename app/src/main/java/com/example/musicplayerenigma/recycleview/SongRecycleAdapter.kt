package com.example.musicplayerenigma.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayerenigma.R
import com.example.musicplayerenigma.model.Song
import com.squareup.picasso.Picasso

class SongRecycleAdapter(
    private val songList: List<Song>,
    private val getActivity: FragmentActivity?
) : RecyclerView.Adapter<LanguageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_recycle_view, parent, false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.albumName.text = songList[position].title
        holder.artistName.text = songList[position].artist
        Picasso.with(getActivity).load(songList[position].imgUrl).into(holder.imageView)

        val bundle = bundleOf(Pair("position", position))
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_songListFragment_to_songDetailFragment, bundle)
        }
    }
}

class LanguageViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val albumName = v.findViewById<TextView>(R.id.albumTittleTextView)
    val artistName = v.findViewById<TextView>(R.id.artistTextView)
    val imageView: ImageView = v.findViewById(R.id.imageViewSong)
}
