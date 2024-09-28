package com.submissionandroid.waifucollection

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class ListWaifuAdapter(private val listWaifu: ArrayList<Waifu>) : RecyclerView.Adapter<ListWaifuAdapter.ListViewHolder>(){

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.waifu_image)
        val tvName: TextView = itemView.findViewById(R.id.waifu_name)
        val tvAnime: TextView = itemView.findViewById(R.id.waifu_anime)
        val tvDescription: TextView = itemView.findViewById(R.id.waifu_description)
        val btnCheckWiki: Button = itemView.findViewById(R.id.check_wiki)
        val btnWatchAnime: Button = itemView.findViewById(R.id.watch_anime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.waifu_layout, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listWaifu.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, anime, description, checkWiki, photo, birthday, age, watchAnime) = listWaifu[position]

        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvAnime.text = anime
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener{
            val intentWaifuDetail = Intent(holder.itemView.context, DetailWaifuActivity::class.java)
            intentWaifuDetail.putExtra("key_waifu", listWaifu[holder.adapterPosition])
            holder.itemView.context.startActivity(intentWaifuDetail)
        }


        holder.btnCheckWiki.setOnClickListener {
            val wikiIntent = Intent(Intent.ACTION_VIEW, Uri.parse(checkWiki))
            holder.itemView.context.startActivity(wikiIntent)
        }


        holder.btnWatchAnime.setOnClickListener {
            val youtubeIntent = Intent(Intent.ACTION_VIEW, Uri.parse(watchAnime))
            holder.itemView.context.startActivity(youtubeIntent)
        }
    }
}
