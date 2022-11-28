package com.droidapps.igymhealth.helpers.api

import retrofit2.Call
import retrofit2.http.GET

interface WorkoutAPI {

    @GET("exercise")
    fun getWorkouts() : Call<List<WGERJSON>?>?
//    fun getWorkouts() : Call<ArrayList<WgerX>?>?
//    suspend fun getWorkouts() : Call<List<WgerX>>

}