package com.hu.b1nd.assignment.feature.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hu.b1nd.assignment.R
import com.hu.b1nd.assignment.databinding.ListHomeBinding
import com.hu.b1nd.domain.model.ListHome

class ListHomeAdapter(
    private val list: List<ListHome>,
    private val action: (ListHome) -> Unit
): RecyclerView.Adapter<ListHomeAdapter.ViewHolder>() {
    inner class ViewHolder(binding: ListHomeBinding): RecyclerView.ViewHolder(binding.root) {
        val thumbnail = binding.thumbnail
        val title = binding.title
        val author = binding.author
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener {
                val list = list[adapterPosition]
                action(list)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.thumbnail.setImageBitmap(item.thumbnail)//context.getDrawable(R.drawable.iu)
        holder.title.text = item.title
        holder.author.text = item.author
//        holder.thumbnail.setImage
    }

    override fun getItemCount(): Int = list.size
}