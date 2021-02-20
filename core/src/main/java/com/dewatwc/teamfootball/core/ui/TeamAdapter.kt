package com.dewatwc.teamfootball.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dewatwc.teamfootball.core.R
import com.dewatwc.teamfootball.core.domain.model.Team
import kotlinx.android.synthetic.main.item_card_home.view.*

class TeamAdapter: RecyclerView.Adapter<TeamAdapter.ListViewHolder>(){

    private var listData = ArrayList<Team>()
    var onItemClick: ((Team) -> Unit)? = null

    fun setData(newListData: List<Team>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = listData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.ListViewHolder =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_card_home, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Team) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(data.img)
                    .into(img_logo)
                name.text = data.name
                stadium.text = data.stadium
            }
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

}