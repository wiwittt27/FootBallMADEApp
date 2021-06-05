package com.alawiyaa.footballapp.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alawiyaa.footballapp.core.R
import com.alawiyaa.footballapp.core.databinding.ItemTeamBinding
import com.alawiyaa.footballapp.core.domain.model.Team
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.*

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.ListTeamViewHolder>() {

    private var listData = ArrayList<Team>()
    var onItemClick: ((Team) -> Unit)? = null

    fun setData(newListData: List<Team>?) {
        if (newListData == null) return
            this.listData.clear()
            this.listData.addAll(newListData)
            notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListTeamViewHolder {
       return ListTeamViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_team,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ListTeamViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

   inner class ListTeamViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
       private val binding = ItemTeamBinding.bind(itemView)
       fun bind(data : Team){
           with(binding){
               Glide.with(itemView.context)
                   .load(data.teamBadge)
                   .apply(
                       RequestOptions.placeholderOf(R.drawable.ic_loading)
                           .error(R.drawable.ic_error))
                   .into(imgTeam)
               tvTeamName.text = data.teamName

           }

       }
       init {
           binding.root.setOnClickListener {
               onItemClick?.invoke(listData[adapterPosition])
           }
       }

    }

}