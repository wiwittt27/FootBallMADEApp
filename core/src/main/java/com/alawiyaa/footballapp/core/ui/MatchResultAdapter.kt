package com.alawiyaa.footballapp.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alawiyaa.footballapp.core.R
import com.alawiyaa.footballapp.core.databinding.ItemResultMatchBinding
import com.alawiyaa.footballapp.core.domain.model.Match
import java.util.*

class MatchResultAdapter : RecyclerView.Adapter<MatchResultAdapter.ListMatchHolder>() {


    private var listData = ArrayList<Match>()
    var onItemClick: ((Match) -> Unit)? = null

    fun setData(newListData: List<Match>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MatchResultAdapter.ListMatchHolder {
       return ListMatchHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_result_match,parent,false)
        )
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: MatchResultAdapter.ListMatchHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)

    }


   inner class ListMatchHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

       private val binding = ItemResultMatchBinding.bind(itemView)
    fun bind(data : Match){
        with(binding){
            tvAwayTeam.text = data.awayTeam
            tvHomeTeam.text = data.homeTeam
            tvScoreAwayTeam.text =  data.awayScore
            tvScoreHomeTeam.text = data.homeScore
        }
    }
       init {
           binding.root.setOnClickListener {
               onItemClick?.invoke(listData[adapterPosition])
           }
       }
    }
}