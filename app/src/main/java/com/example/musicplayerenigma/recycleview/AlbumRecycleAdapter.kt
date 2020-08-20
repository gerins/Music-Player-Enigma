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
import com.example.musicplayerenigma.room.album.Album
import com.example.musicplayerenigma.room.album.AlbumWithSong
import com.squareup.picasso.Picasso

class AlbumRecycleAdapter(
    private val albumList: List<Album>,
    private val getActivity: FragmentActivity?
) : RecyclerView.Adapter<AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_recycle_view, parent, false)
        return AlbumViewHolder(view)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.albumName.text = albumList[position].albumTitle
        holder.artistName.text = albumList[position].artist
        Picasso.with(getActivity).load(albumList[position].imgUrl).into(holder.imageView)

        val bundle = bundleOf(Pair("albumId", albumList[position].albumId))
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_songListFragment_to_songDetailFragment, bundle)
        }
    }
}

class AlbumViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val albumName = v.findViewById<TextView>(R.id.albumTittleTextView)
    val artistName = v.findViewById<TextView>(R.id.artistTextView)
    val imageView: ImageView = v.findViewById(R.id.imageViewSong)
}
