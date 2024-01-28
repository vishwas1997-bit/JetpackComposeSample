package com.example.jetpackcompose.core.api

import com.example.jetpackcompose.netclan.data.model.remote.dto.response.IndividualExploreResponseDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @Headers("Content-Type: application/json")
    @GET("user/explore/getExplore/type/{Id}")
    suspend fun getExploreIndividualUsers(
        @Path("Id") typeId: Int,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<IndividualExploreResponseDto>
}