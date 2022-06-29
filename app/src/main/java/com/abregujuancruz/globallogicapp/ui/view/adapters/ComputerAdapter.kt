package com.abregujuancruz.globallogicapp.ui.view.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abregujuancruz.globallogicapp.R
import com.abregujuancruz.globallogicapp.data.models.Computer
import com.abregujuancruz.globallogicapp.ui.view.DetailsActivity
import com.abregujuancruz.globallogicapp.utils.Constants

class ComputerAdapter(private val computerList: ArrayList<Computer>) :
    RecyclerView.Adapter<ComputerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComputerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ComputerViewHolder(
            layoutInflater.inflate(R.layout.computer_items, parent, false)
        )
    }
    
    override fun onBindViewHolder(holder: ComputerViewHolder, position: Int) {
        val computer = computerList[position]
        holder.bind(computer.title, computer.description, computer.image, position)
        holder.binding.constraint.setOnClickListener {
            val intent = Intent(it.context, DetailsActivity::class.java)
            intent.putExtra(Constants.TITLE_EX, computer.title)
            intent.putExtra(Constants.DESCRIPTION_EX, computer.description)
            intent.putExtra(Constants.IMAGE_EX, computer.image)
            intent.putExtra(Constants.POSITION_EX, position.toString())
            it.context.startActivity(intent)
        }
        
    }
    
    override fun getItemCount(): Int = computerList.size
}