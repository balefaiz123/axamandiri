package com.assesment.axamandiri.activity.home_activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.assesment.axamandiri.common.entity.DataResponse
import com.assesment.axamandiri.common.entity.DataResponseItem
import com.assesment.axamandiri.databinding.HomeItemBinding
import com.bumptech.glide.Glide

class Adapter : RecyclerView.Adapter<Adapter.DataViewHolder>() {

    inner class DataViewHolder(val binding: HomeItemBinding) : RecyclerView.ViewHolder(binding.root)

    val data = AsyncListDiffer(this, diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            HomeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = data.currentList[position]
        holder.binding.text.text=data.title
        Glide.with(holder.binding.root)
            .load("${data.thumbnailUrl}.png")
            .into(holder.binding.image)

    }

    override fun getItemCount(): Int {
        return data.currentList.size
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DataResponseItem>() {
            override fun areItemsTheSame(
                oldItem: DataResponseItem,
                newItem: DataResponseItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: DataResponseItem,
                newItem: DataResponseItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}