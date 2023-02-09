package com.example.weak4day4ktorapirequsttutorial.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.weak4day4ktorapirequsttutorial.databinding.PostItemBinding
import com.example.weak4day4ktorapirequsttutorial.model.Post

class PostAdapter : androidx.recyclerview.widget.ListAdapter<Post, RecyclerView.ViewHolder>(DIFF_CALLBACK){
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Post>() {

            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
//                return oldItem.id == newItem.id
                return oldItem.message == newItem.message

            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
//                return oldItem.title == newItem.title || oldItem.content == newItem.content ||
//                oldItem.picture == newItem.picture
                  return oldItem.message == newItem.message || oldItem.status == newItem.status
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        val  binding: PostItemBinding =
            PostItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item)
        }
    }


    inner class ViewHolder(val itemBinding: PostItemBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Post){
            itemBinding.apply {
//                tvTitle.text = item.title
//                tvContent.text = item.content
//                ivPicture.load(item.picture)
                tvTitle.text = item.status
//                tvContent.text = item.content
                ivPicture.load(item.message)
            }
        }
    }
}