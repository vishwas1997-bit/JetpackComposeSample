package com.example.jetpackcompose.netclan.data.datasource.remote

import com.example.jetpackcompose.netclan.data.model.remote.dto.response.IndividualExploreResponseDto
import retrofit2.Response

interface NetworkExploreDataSource {
    suspend fun getIndividualExploreUsers(pageNumber: Int): Response<IndividualExploreResponseDto>
}