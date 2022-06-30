package com.abregujuancruz.globallogicapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.abregujuancruz.globallogicapp.databinding.ActivityListComputerBinding
import com.abregujuancruz.globallogicapp.data.models.Computer
import com.abregujuancruz.globallogicapp.ui.view.adapters.ComputerAdapter
import com.abregujuancruz.globallogicapp.ui.viewmodel.ComputerViewModel

class ComputerListActivity : AppCompatActivity() {
    
    private lateinit var binding : ActivityListComputerBinding
    private val computerViewModel : ComputerViewModel by viewModels()
    private lateinit var computerList : ArrayList<Computer>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListComputerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    
        computerViewModel.getListOfComputers()
        computerViewModel.computerData.observe(this){
            computerList = it
            initRecyclerView(computerList)
        }
        
    }
    
    private fun initRecyclerView(computerList : ArrayList<Computer>) {
        binding.rvComputer.adapter = ComputerAdapter(computerList)
        binding.rvComputer.layoutManager = LinearLayoutManager(this)
       
        computerViewModel.controlVisibility()
        computerViewModel.visibility.observe(this) {
            binding.rvComputer.visibility = if(it) View.VISIBLE else View.GONE
            binding.tvTitleList.visibility = if(it) View.VISIBLE else View.GONE
            binding.shimmerLayout.visibility = if(it) View.GONE else View.VISIBLE
        }
    }
    
}