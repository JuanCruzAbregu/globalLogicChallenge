package com.abregujuancruz.globallogicapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abregujuancruz.globallogicapp.data.models.ComputerResponse
import com.abregujuancruz.globallogicapp.data.network.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ComputerViewModel : ViewModel() {
    
    val computerData = MutableLiveData<ComputerResponse>()
    private val apiService = APIService()
    
    fun getListOfComputers() {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Call<ComputerResponse> = apiService.getListOfComputers()
            call.enqueue(object : Callback<ComputerResponse> {
                override fun onResponse(
                    call: Call<ComputerResponse>,
                    response: Response<ComputerResponse>
                ) {
                    computerData.postValue(response.body())
                }
                override fun onFailure(call: Call<ComputerResponse>, t: Throwable) {
                    Log.e("Error!: ", t.message.toString())
                }
            })
        }
    }
}