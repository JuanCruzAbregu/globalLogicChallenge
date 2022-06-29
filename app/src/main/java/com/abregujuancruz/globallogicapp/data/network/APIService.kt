package com.abregujuancruz.globallogicapp.data.network

import com.abregujuancruz.globallogicapp.data.models.ComputerResponse
import com.abregujuancruz.globallogicapp.utils.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIService : ComputerAPI {
    
    private lateinit var retrofit: Retrofit
    private lateinit var computerAPI: ComputerAPI
    
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    override fun getListOfComputers(): Call<ComputerResponse> {
        retrofit = getRetrofit()
        computerAPI = retrofit.create(ComputerAPI::class.java)
        return computerAPI.getListOfComputers()
    }
}