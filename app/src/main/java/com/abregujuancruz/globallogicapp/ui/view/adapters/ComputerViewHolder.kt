package com.abregujuancruz.globallogicapp.ui.view.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.abregujuancruz.globallogicapp.databinding.ComputerItemsBinding
import com.bumptech.glide.Glide

class ComputerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    
    val binding = ComputerItemsBinding.bind(view)
    
    fun bind(title: String, description: String, url: String, position: Int) {
        binding.tvTitleComputer.text = title
        binding.tvDescription.text = description
        if (position != 9) {
            Glide.with(binding.ivComputer.context)
                .load(url)
                .into(binding.ivComputer)
        } else {
            binding.ivComputer.visibility = View.GONE
        }
    }
    
}