package com.rakib.needmedicinapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.rakib.needmedicinapps.data.local.Banner
import com.rakib.needmedicinapps.databinding.SlideItemBinding

class SliderAdapter : ListAdapter<Banner, SliderAdapter.SliderViewHolder>(Comparator) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val layOutBinding =
            SlideItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderViewHolder(layOutBinding)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        getItem(position)?.let {
            holder.binding.title.text = it.title
            holder.binding.slideImg.load(it.slideImg)
        }

    }
    inner class SliderViewHolder(val binding: SlideItemBinding) : ViewHolder(binding.root) {
    }

    companion object {
        private val Comparator =
            object : DiffUtil.ItemCallback<Banner>() {
                override fun areItemsTheSame(
                    oldItem: Banner,
                    newItem: Banner
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: Banner,
                    newItem: Banner
                ): Boolean {
                    return oldItem == newItem
                }

            }

    }
}