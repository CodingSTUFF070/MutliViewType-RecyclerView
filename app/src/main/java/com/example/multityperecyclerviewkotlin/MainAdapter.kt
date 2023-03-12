package com.example.multityperecyclerviewkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multityperecyclerviewkotlin.databinding.ItemWithPosterBinding
import com.example.multityperecyclerviewkotlin.databinding.ItemWithoutPosterBinding


const val ITEM_WITH_POSTER = 0
const val ITEM_WITHOUT_POSTER = 1

class MainAdapter(private val mList: List<DataItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class ItemWithPosterViewHolder(private val binding: ItemWithPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindPosterView(dataItem: DataItem) {
            dataItem.poster?.let { binding.posterIv.setImageResource(it) }
            binding.movieTitleTv.text = dataItem.title
            binding.movieDescTv.text = dataItem.desc
        }
    }

    inner class ItemWithoutPosterViewHolder(private val binding: ItemWithoutPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindWithoutPosterView(dataItem: DataItem) {
            binding.movieTitleTv.text = dataItem.title
            dataItem.logo?.let { binding.logoIv.setImageResource(dataItem.logo) }
        }
    }

    override fun getItemViewType(position: Int): Int {

        if (mList[position].poster != null) {
            return ITEM_WITH_POSTER
        } else {
            return ITEM_WITHOUT_POSTER
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == ITEM_WITH_POSTER) {
            val binding =
                ItemWithPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemWithPosterViewHolder(binding)

        } else {
            val binding =
                ItemWithoutPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemWithoutPosterViewHolder(binding)
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == ITEM_WITH_POSTER) {
            (holder as ItemWithPosterViewHolder).bindPosterView(mList[position])
        } else {
            (holder as ItemWithoutPosterViewHolder).bindWithoutPosterView(mList[position])
        }
    }
}